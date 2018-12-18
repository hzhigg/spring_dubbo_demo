/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.common.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.BaseDao;
import com.common.entity.DataEntity;
import com.common.util.Page;



/**
 * Service基类
 * @author jeeplus
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<D extends BaseDao<T>, T extends DataEntity<T>> implements BaseService<T> {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly=false)
	public int updateByPrimaryKeySelective(T entity){
		return dao.updateByPrimaryKeySelective(entity);
	}
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Long id) {
		return dao.selectByPrimaryKey(id);
	}
	
	/**
	 * 删除数据（物理删除，从数据库中彻底删除）
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Transactional(readOnly=false)
	public int deleteByPrimaryKey(Long id){
		return dao.deleteByPrimaryKey(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T selectByEntity(T entity) {
		return dao.selectByEntity(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewRecord()){
			dao.insertSelective(entity);
		}else{
			dao.updateByPrimaryKeySelective(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int delete(T entity) {
		return dao.delete(entity);
	}
	
	
	/**
	 * 删除全部数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void deleteAll(Collection<T> entitys) {
		for (T entity : entitys) {
			dao.delete(entity);
		}
	}

	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T findUniqueByProperty(String propertyName, Object value){
		return dao.findUniqueByProperty(propertyName, value);
	}
	
	/**
	 * 查询所有数据列表
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity){
		return dao.findAllList(entity);
	}
	
	/**
	 * 查询所有数据列表
	 * @see public List<T> findAllList(T entity)
	 * @return
	 */
	@Deprecated
	public List<T> findAllList(){
		return dao.findAllList();
	}
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly=false)
	public int insertSelective(T entity) {
		// TODO Auto-generated method stub
		return dao.insertSelective(entity);
	}
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Transactional(readOnly=false)
	public int deleteByLogic(Long id) {
		// TODO Auto-generated method stub
		return dao.deleteByLogic(id);
	}
	
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly=false)
	public int deleteByLogic(T entity) {
		// TODO Auto-generated method stub
		return dao.deleteByLogic(entity);
	}
	
}

