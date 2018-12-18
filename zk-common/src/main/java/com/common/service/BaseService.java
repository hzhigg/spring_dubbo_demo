/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.common.service;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.common.util.Page;


/**
 * Service基类
 * @author jeeplus
 * @version 2014-05-16
 */

public interface BaseService<T> {
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Long id);
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T selectByEntity(T entity);
	
	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public  T findUniqueByProperty(@Param(value="propertyName")String propertyName, @Param(value="value")Object value);

	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 查询所有数据列表
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity);
	
	/**
	 * 查询所有数据列表
	 * @see public List<T> findAllList(T entity)
	 * @return
	 */
	@Deprecated
	public List<T> findAllList();
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insertSelective(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int updateByPrimaryKeySelective(T entity);
	
	/**
	 * 删除数据（物理删除，从数据库中彻底删除）
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Deprecated
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Deprecated
	public int deleteByLogic(Long id);
	
	/**
	 * 删除数据（物理删除，从数据库中彻底删除）
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
	 * @param entity
	 * @return
	 */
	public int deleteByLogic(T entity);
	
	/**
	 * 删除全部数据
	 * @param entity
	 */
	public void deleteAll(Collection<T> entitys);

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity);


}
