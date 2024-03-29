package com.library.bookhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bookhub.entity.User;
import com.library.bookhub.repository.PointRepository;
import com.library.bookhub.web.dto.point.PointOrderRequestDto;

@Service
public class PointService {
	
	@Autowired
	private PointRepository pointRepository;
	
	public User getMyPoint(String userName) {
		return pointRepository.getUser(userName);
	}
	
	@Transactional
	public boolean ProductOrder(List<PointOrderRequestDto> orderList) {
		// bh_point_order 테이블에 리스트 전부 저장하는데,
		// 해당 아이디의 orderId 마지막 번호를 가져와서 +1 한 후 등록할것
		int orderId = 0;
		Integer userOrderId = pointRepository.getUserOrderId(orderList.get(0).getUserName());
		if(userOrderId == null) {
			orderId = 1;
		}else {
			orderId = userOrderId + 1;
		}
		int cafeOrderResult = 0;
		int allOrderPoint = 0;
		for(int i = 0; i < orderList.size(); i++) {
			allOrderPoint = allOrderPoint + orderList.get(i).getAllProductPrice();
			orderList.get(i).setOrderId(orderId);
			cafeOrderResult += pointRepository.ProductOrder(orderList.get(i).toEntity());
		}
		if(cafeOrderResult == 0) {
			throw new RuntimeException("결제내역 insert 실패");
		}
		// 위 작업이 다 끝나면 전체 결제한 포인트를 유저 정보에 업데이트
		User user = pointRepository.getUser(orderList.get(0).getUserName());
		if(user != null) {
			System.out.println("6=============================================");
			user.setPoint(user.getPoint() - allOrderPoint);
			System.out.println("------------" + user.toString());
			int userPointUpdateResult = pointRepository.userPointUpdate(user);
			if(userPointUpdateResult == 0) {
				throw new RuntimeException("유저 포인트 정보 업데이트 실패!");
			}
		}
		
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
