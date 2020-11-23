package com.hungerbox.service;

import java.util.List;

import com.hungerbox.dto.FoodOrdersResponseDto;
import com.hungerbox.dto.UserOrderRequestDto;

public interface OrederService {

	void saveOrder (UserOrderRequestDto userOrderRequestDto);
	public List<FoodOrdersResponseDto> getOrderList(int userId, int pageNumber, int pageSize);
	public String getInfo();

}
