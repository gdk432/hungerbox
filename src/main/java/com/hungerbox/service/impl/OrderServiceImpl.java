package com.hungerbox.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hungerbox.dto.FoodItemRequestDto;
import com.hungerbox.dto.FoodOrdersResponseDto;
import com.hungerbox.dto.UserOrderRequestDto;
import com.hungerbox.dto.UserTransactionRequestDto;
import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.FoodOrders;
import com.hungerbox.entity.OrderItem;
import com.hungerbox.entity.User;
import com.hungerbox.entity.Vendor;
import com.hungerbox.feignclients.BankClient;
import com.hungerbox.repository.FoodMenuRepository;
import com.hungerbox.repository.OrderRepository;
import com.hungerbox.repository.UserRepository;
import com.hungerbox.repository.VendorRepository;
import com.hungerbox.service.OrederService;

@Service
public class OrderServiceImpl implements OrederService {

	@Autowired
	FoodMenuRepository foodmenuRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	BankClient bankClient;
	
	@Override
	public void saveOrder(UserOrderRequestDto userOrderRequestDto) {
		FoodOrders foodOrders = new FoodOrders();
		OrderItem orderItem = new OrderItem();
		Optional<User> optionalUser = userRepository.findById(userOrderRequestDto.getUserid());
		long totalprice = 0;
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			foodOrders.setUserId(user.getUserId());
			for (FoodItemRequestDto foodItemRequestDto : userOrderRequestDto.getFooddetails()) {
				Optional<FoodMenu> optionalfoodmenu = foodmenuRepository.findById(foodItemRequestDto.getFoodid());
				if(optionalfoodmenu.isPresent()) {
					FoodMenu foodmenu = optionalfoodmenu.get();
					long selecteditemprice = foodmenu.getFoodPrice();
					long selecteditemtotal = (selecteditemprice * foodItemRequestDto.getQuantity());
					totalprice = (totalprice + selecteditemtotal);
					foodOrders.setTotalPrice(totalprice);
					foodOrders.setFoodName(foodmenu.getFoodName());
					foodOrders.setVendorName(foodmenu.getVendorName());
					foodOrders.setOrderstatus("pending");
					orderRepository.save(foodOrders);
					
					Optional<Vendor> optionalVendor = vendorRepository.findById(foodmenu.getVendorId());
					if(optionalVendor.isPresent()) {
						Vendor vendor = optionalVendor.get();
						UserTransactionRequestDto userTransactionRequestDto = new UserTransactionRequestDto();
						userTransactionRequestDto.setTo_account_number(vendor.getVenodrAccountNo());
						userTransactionRequestDto.setFrom_account_number(userOrderRequestDto.getFrom_account_no());
						userTransactionRequestDto.setTransfer_amount(totalprice);
						userTransactionRequestDto.setUser_comment("hungerbox-order");
						bankClient.transferfund(userTransactionRequestDto);
					}
					foodOrders.setOrderstatus("success");
				}
				
			}
			
			
			
			orderRepository.save(foodOrders);
			
		}
		
	}
	
	
	
	@Override
	public List<FoodOrdersResponseDto> getOrderList(int userId, int pageNumber, int pageSize) {
		
		List<FoodOrders> foodOrdersList = new ArrayList();
		List<FoodOrdersResponseDto> foodOrderResponseDtoList = new ArrayList();
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "foodName"));
		foodOrdersList = orderRepository.findByuserId(userId,pageable);
		
		for (FoodOrders foodOreders : foodOrdersList) {
			FoodOrdersResponseDto foodOrdersResponseDto = new FoodOrdersResponseDto();
			BeanUtils.copyProperties(foodOreders, foodOrdersResponseDto);
			foodOrderResponseDtoList.add(foodOrdersResponseDto);
		}
		return foodOrderResponseDtoList;
	}



	@Override
	public String getInfo() {
		
		return bankClient.getInfo();
	}
	
	
}
