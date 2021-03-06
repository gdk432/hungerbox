package com.hungerbox.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	public List<Vendor> findByvendorNameContains(@Param("vendorName") String vendorName, Pageable pageRequest);
	
}
