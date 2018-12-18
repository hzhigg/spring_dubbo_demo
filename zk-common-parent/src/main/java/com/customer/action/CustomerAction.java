/*package com.customer.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.provider.server.DemoService;



@Controller
@RequestMapping(value="/customerTest")
public class CustomerAction {
    
    @Resource(name="demoService")
    private DemoService demoService;

    @RequestMapping(value="/test.do")
    public ModelAndView test(HttpServletRequest request,HttpServletResponse response){
        System.out.println("³É¹¦");
        String result = demoService.sayHello("world");
        System.out.println(result);
        return null;
    }
    
}*/