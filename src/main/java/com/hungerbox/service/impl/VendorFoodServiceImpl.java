package com.hungerbox.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hungerbox.dto.FoodMenuResponseDto;
import com.hungerbox.dto.VendorResponseDto;
import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.Vendor;
import com.hungerbox.repository.FoodMenuRepository;
import com.hungerbox.repository.VendorRepository;
import com.hungerbox.service.VendorFoodService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class VendorFoodServiceImpl implements VendorFoodService{

	@Autowired
	FoodMenuRepository foodmenuRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Override
	public List<VendorResponseDto> findByfoodNameContains(String foodName, int pageNumber, int pageSize) {
		
		List<VendorResponseDto> vendorResponseDtoList = new ArrayList();
		List<FoodMenu> foodMenuList = new ArrayList();
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "foodName"));
		foodMenuList = foodmenuRepository.findByfoodNameContains(foodName,pageable);
		
//		if(foodMenuList.size()>0) {
//			List<Vendor> vendors = vendorRepository.findAll();
//			for (Vendor vendor : vendors) {
//				if(vendor.getFoodMenu().containsAll(foodMenuList)) {
//					VendorResponseDto vendorDto = new VendorResponseDto();
//					BeanUtils.copyProperties(vendor, vendorDto);
//					for(FoodMenu foodMenu : foodMenuList) {
//						if(vendor.getFoodMenu().contains(foodMenu)) {
//							FoodMenuResponseDto foodMenuDto = new FoodMenuResponseDto();
//							BeanUtils.copyProperties(foodMenu, foodMenuDto);
//							vendorDto.getFooditemDto().add(foodMenuDto);
//						}
//					}
//					vendorResponseDtoList.add(vendorDto);
//				}
//			}
//			
//		}
	return vendorResponseDtoList;
		
		
	}

}
