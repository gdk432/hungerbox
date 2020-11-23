package com.hungerbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.entity.Vendor;
import com.hungerbox.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@GetMapping("/searchbyvendorname")
	public List<Vendor> getVendorWithVendorName(@RequestParam String vendorName, @RequestParam int pageNumber, @RequestParam int pageSize){
	
		return vendorService.findByvendorNameContains(vendorName,pageNumber,pageSize);
	}
}

 