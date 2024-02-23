package com.library.bookhub.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bookhub.entity.User;
import com.library.bookhub.service.PointService;
import com.library.bookhub.web.dto.point.PointOrderRequestDto;

@RestController
@RequestMapping("/point")
public class PointController {
	
	@Autowired
	private PointService pointService;

	@PostMapping("/get")
	public ResponseEntity<?> getMyPoint(String userName){
		User user = pointService.getMyPoint(userName);
		return new ResponseEntity<Integer>(user.getPoint(), HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> ProductOrder(@RequestBody List<PointOrderRequestDto> orderList){
		for(int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
		boolean result = pointService.ProductOrder(orderList);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
