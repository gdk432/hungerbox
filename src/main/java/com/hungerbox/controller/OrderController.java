package com.hungerbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.dto.FoodOrdersResponseDto;
import com.hungerbox.dto.UserOrderRequestDto;
import com.hungerbox.service.OrederService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrederService orderService;
	
	@PostMapping("/placeorder")
	public String placeOrder(@RequestBody UserOrderRequestDto userOrderRequestDto){
		
		orderService.saveOrder(userOrderRequestDto);
		 return "OrderPlaced-Succssfully";
	}
	
	@GetMapping("/vieworders")
	public List<FoodOrdersResponseDto> getOrderList(@RequestParam int userId, @RequestParam int pageNumber, @RequestParam int pageSize){
	
		return orderService.getOrderList(userId,pageNumber,pageSize);
	}
	
	
}
