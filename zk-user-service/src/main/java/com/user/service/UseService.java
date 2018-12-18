package com.user.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.service.BaseServiceImpl;
import com.facade.entity.User;
import com.facade.service.UserFacadeService;
import com.user.dao.UserMapper;

@Service("useService")
public class UseService extends BaseServiceImpl<UserMapper,User> implements UserFacadeService{

	@Autowired
	private UserMapper userMapper;


	public String getNameById(Long id){
		return userMapper.getNameById(id);
	}
}
