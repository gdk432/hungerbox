package com.hungerbox.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.Vendor;
import com.hungerbox.repository.FoodMenuRepository;
import com.hungerbox.repository.VendorRepository;
import com.hungerbox.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	FoodMenuRepository foodMenuRespository;
	
	@Override
	public List<Vendor> findByvendorNameContains(String vendorName, int pageNumber, int pageSize) {
		
//		List<Vendor> vendorList = new ArrayList();
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "vendorName"));
		return vendorRepository.findByvendorNameContains(vendorName,pageable); 
		
//		for (Vendor vendor : vendorList) {
//			Vendor vendors = new Vendor();
//			for(FoodMenu foodMenu : vendor.getFoodMenu()) {
//				vendor.getFoodMenu().add(foodMenu);
//			}
//			vendorList.add(vendor);
//		}
		
	}
	
}
