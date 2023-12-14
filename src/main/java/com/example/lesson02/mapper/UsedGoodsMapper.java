package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	
	// input : X (BO로 부터 받아오는 것)
	// ouput : (Service에게 주는 것) List<UsedGoods>
	
	public List<UsedGoods> selectUsedGoodsList();
	
}
