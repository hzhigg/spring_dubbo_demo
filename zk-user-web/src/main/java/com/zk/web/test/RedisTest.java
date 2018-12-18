package com.zk.web.test;





import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.util.RedisCacheUtil;


/**
 * ����
 */
public class RedisTest {

    private RedisCacheUtil redisCache;
    private static String key;
    private static String field;
    private static String value;
    
    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();
        redisCache = (RedisCacheUtil) context.getBean("redisCache");
    }

    // ��ʼ�� ����
    static {
        key = "tb_student";
        field = "stu_name";
        value = "һϵ�еĹ���student����Ϣ��";
    }
    
    // ������������
    @Test
    public void testHset() {
        redisCache.hset(key, field, value);
        System.out.println("���ݱ���ɹ���");
    }

    // ���Բ�ѯ����
    @Test
    public void testHget(){
        String re = redisCache.hget(key, field);
        System.out.println("�õ������ݣ�" + re);
    }
    
    // �������ݵ�����
    @Test
    public void testHsize(){
        long size = redisCache.hsize(key);
        System.out.println("����Ϊ��" + size);
    }
}