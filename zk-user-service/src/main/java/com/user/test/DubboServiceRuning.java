package com.user.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 本地main方法启动服务
 * @author Administrator
 *
 */
public class DubboServiceRuning {

	private static final Log log=LogFactory.getLog(DubboServiceRuning.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext content=new ClassPathXmlApplicationContext("classpath:spring-context.xml");
			content.start();
		} catch (Exception e) {
			//e.printStackTrace();
			log.error(e);
		}
		synchronized (DubboServiceRuning.class) {
			while (true) {
				try {
					DubboServiceRuning.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e);
				}
				
				
			}
		}
		
	}

}
