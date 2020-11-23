package com.hungerbox.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.hungerbox.entity.FoodMenu;

public class VendorResponseDto {

	private int vendorId;
	private String vendorName;
	private String vendorDesc;
	private String vendorLocation;
	private String vendorPhoneNo;
	private String vendorEmail;
	private List <FoodMenu> foodMenu;
	private List<FoodMenuResponseDto> fooditemDto;
	
	
	
	
	public List<FoodMenuResponseDto> getFooditemDto() {
		return fooditemDto;
	}
	public void setFooditemDto(List<FoodMenuResponseDto> fooditemDto) {
		this.fooditemDto = fooditemDto;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorDesc() {
		return vendorDesc;
	}
	public void setVendorDesc(String vendorDesc) {
		this.vendorDesc = vendorDesc;
	}
	public String getVendorLocation() {
		return vendorLocation;
	}
	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
	public String getVendorPhoneNo() {
		return vendorPhoneNo;
	}
	public void setVendorPhoneNo(String vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public List<FoodMenu> getFoodMenu() {
		return foodMenu;
	}
	public void setFoodMenu(List<FoodMenu> foodMenu) {
		this.foodMenu = foodMenu;
	}
	
	

}
