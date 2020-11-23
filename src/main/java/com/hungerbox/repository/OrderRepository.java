package com.hungerbox.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.FoodOrders;

public interface OrderRepository extends  JpaRepository<FoodOrders, Integer> {

	public List<FoodOrders> findByuserId(@Param("userId") int userId,Pageable pageRequest);
}
