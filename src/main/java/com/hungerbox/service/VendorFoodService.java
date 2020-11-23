package com.hungerbox.service;

import java.util.List;

import com.hungerbox.dto.VendorResponseDto;

public interface VendorFoodService {

	List<VendorResponseDto> findByfoodNameContains(String foodName, int pageNumber, int pageSize);

}
