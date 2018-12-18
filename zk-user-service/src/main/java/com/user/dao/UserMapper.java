package com.user.dao;




import com.common.dao.BaseDao;
import com.facade.entity.User;


public interface UserMapper extends BaseDao<User>{

	String getNameById(Long id);

}