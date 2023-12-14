package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // Business Object에 관한 Spring bean 등록
public class UsedGoodsBO {
	
	// input : X (ex)DB의 where절 <- 컨트롤러에게 받아온다		
	// output : (Repository에게 받은 것을) List<UsedGoods> (컨트롤러에게 전달)
	public List<UsedGoods> getUsedGoodsList() {
		return ;
	}
	
}
