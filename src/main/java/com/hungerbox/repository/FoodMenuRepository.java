package com.hungerbox.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hungerbox.entity.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {

	public List<FoodMenu> findByfoodNameContains(@Param("foodName") String foodName,Pageable pageRequest);
}
