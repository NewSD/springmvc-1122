package com.niu.vo;

import com.niu.entity.Orderdetail;
import com.niu.entity.Orders;
import com.niu.entity.User;

import java.util.List;

/**
 * 订单自定义po，包括订单信息、用户信息
 * 
 */
public class OrdersVo extends Orders {

	//用户信息
	private UserVo userVo;
	//订单明细
	private List<Orderdetail> orderdetails;

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
