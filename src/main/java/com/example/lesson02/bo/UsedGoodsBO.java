package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // Business Object에 관한 Spring bean 등록
public class UsedGoodsBO {
	
	@Autowired // Dependency Injection(DI): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // Spring Bean을 가져온다.
	
	// input : X (ex)DB의 where절 <- 컨트롤러에게 받아온다		
	// output : (Repository에게 받은 것을) List<UsedGoods> (컨트롤러에게 전달)
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
}
