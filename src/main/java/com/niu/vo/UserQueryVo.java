package com.niu.vo;

import com.niu.entity.User;

import java.util.List;

public class UserQueryVo {
	
	//自定义用户扩展类
	private UserVo userVo;
	
	//传递多个用户id
	private List<Integer> ids;
	
	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}



}
