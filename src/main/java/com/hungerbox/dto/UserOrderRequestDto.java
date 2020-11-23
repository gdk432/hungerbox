package com.hungerbox.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungerbox.entity.FoodMenu;

public class UserOrderRequestDto {

	private int userid;
	private List<FoodItemRequestDto> fooddetails = new ArrayList();
	private long from_account_no;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<FoodItemRequestDto> getFooddetails() {
		return fooddetails;
	}
	public void setFooddetails(List<FoodItemRequestDto> fooddetails) {
		this.fooddetails = fooddetails;
	}
	public long getFrom_account_no() {
		return from_account_no;
	}
	public void setFrom_account_no(long from_account_no) {
		this.from_account_no = from_account_no;
	}
	
	
	
	
}
