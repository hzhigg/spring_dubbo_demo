package com.facade.service;





import com.common.service.BaseService;
import com.facade.entity.User;


public interface UserFacadeService extends BaseService<User>{
	
	String getNameById(Long id);

}
