package com.library.bookhub.repository;

import org.apache.ibatis.annotations.Mapper;

import com.library.bookhub.entity.PointOrder;
import com.library.bookhub.entity.User;

@Mapper
public interface PointRepository {
	
	public Integer getUserOrderId(String userName);
	public int ProductOrder(PointOrder pointOrder);
	public User getUser(String userName);
	public int userPointUpdate(User user);

}
