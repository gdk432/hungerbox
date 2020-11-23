package com.hungerbox.service;

import java.util.List;

import com.hungerbox.entity.Vendor;

public interface VendorService {

	
	public List<Vendor> findByvendorNameContains(String vendorName,int pageNumber, int pageSize);

}
