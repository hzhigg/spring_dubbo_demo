package com.zk.web.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zk.web.UserController;

public class Test {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(User.class.getName());  

		
	}*/
	
	  @org.junit.Test
      public void testSayHello() throws Exception {
  //TODO: Test goes here...
          UserController helloController = new UserController();
          MockMvc mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
          mockMvc.perform(MockMvcRequestBuilders.get("/user/showUser?id=1")).andExpect(view().name("hello"));
      }


}
