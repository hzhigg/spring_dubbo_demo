package com.common.util;


import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 操作 hash 的基本操作
 * @author xbq
 */
@Component("redisCache")
public class RedisCacheUtil {

    @Resource
    private StringRedisTemplate  redisTemplate;
    
    
    /**
     * 添加字符串
     * @param key
     * @param value
     */
    public void sValue(String key ,String value){
    	 if(key == null || "".equals(key)){
             return ;
         }
    	redisTemplate.opsForValue().set(key, value);
    }
    
    /**
     * 添加字符串并设置过期时间
     * @param key
     * @param value
     * @param timeout 过期时间秒单位
     */
    public void sValueTime(String key ,String value,long timeout){
   	 if(key == null || "".equals(key)){
            return ;
        }
   	redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
   }
    
    /**
     * 向Hash中添加值
     * @param key      可以对应数据库中的表名
      * @param field    可以对应数据库表中的唯一索引
     * @param value    存入redis中的值
     */
    public void hset(String key, String field, String value) {
        if(key == null || "".equals(key)){
            return ;
        }
        redisTemplate.opsForHash().put(key, field, value);
    }
    
    /**
     * 向Hash中添加值和过期时间
     * @param key      可以对应数据库中的表名
      * @param field    可以对应数据库表中的唯一索引
     * @param value    存入redis中的值
     * @param timeout    过期时间秒单位
     */
    public void hsetTime(String key, String field, String value,long timeout){
    	 if(key == null || "".equals(key)){
             return ;
         }
         redisTemplate.opsForHash().put(key, field, value);
         redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
    
    /**
     * 从redis中取出值
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field){
        if(key == null || "".equals(key)){
            return null;
        }
        return (String) redisTemplate.opsForHash().get(key, field);
    }
    
    /**
     * 判断 是否存在 key 以及 hash key
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(String key, String field){
        if(key == null || "".equals(key)){
            return false;
        }
        return redisTemplate.opsForHash().hasKey(key, field);
    }
    
    /**
     * 查询 key中对应多少条数据
     * @param key
     * @return
     */
    public long hsize(String key) {
        if(key == null || "".equals(key)){
            return 0L;
        }
        return redisTemplate.opsForHash().size(key);
    }
    
    /**
     * 删除
     * @param key
     * @param field
     */
    public void hdel(String key, String field) {
        if(key == null || "".equals(key)){
            return;
        }
        redisTemplate.opsForHash().delete(key, field);
    }
}