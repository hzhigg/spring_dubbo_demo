package com.zk.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.global.RtnResult;
import com.common.util.Page;
import com.common.util.RedisCacheUtil;
import com.facade.entity.User;
import com.facade.service.UserFacadeService;




//@Component  
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    /*@Autowired(required=false)
    private UserFacadeService userFacadeService;*/
    
	@Autowired
	private UserFacadeService userService;
    @Autowired
    private RedisCacheUtil redisCache;
    
    @Value("${redis.maxIdle}")
    private String redis;
    
    @Value("${redis.maxIdle}")
    private int redis2;
    
    @RequestMapping("/not-login")
    public ModelAndView notLogin(){
    	ModelAndView mav=new ModelAndView();
		mav.setViewName("login");

    	return mav;
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    @ResponseBody
    public RtnResult login(HttpServletRequest request){
    	 User user = this.userService.selectByPrimaryKey(1L);
    	 request.getSession().setAttribute("user", user);
    	return RtnResult.Success(user);
    }
    
    @RequestMapping("/showUser")
    @ResponseBody
    public RtnResult toIndex(HttpServletRequest request,HttpServletResponse response, Model model) {
    	response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Long userId = Long.valueOf(request.getParameter("id"));
        User user = this.userService.selectByPrimaryKey(userId);
        User user2 = this.userService.selectByPrimaryKey(userId);
        user.setAge(100);
        userService.updateByPrimaryKeySelective(user);
        model.addAttribute("users", user);
        return RtnResult.Success(user);
    }
    
    @RequestMapping("/showUser2")
    @ResponseBody
    public RtnResult toIndex2(HttpServletRequest request, HttpServletResponse response,User user) {
    	Map<String, Object> map=new HashMap<>();
        Page<User> page=userService.findPage(new Page<>(request, response),user);
        map.put("data", page);
        return RtnResult.Success(map);
    }
    
    @RequestMapping("/getNameById")
    @ResponseBody
    public RtnResult getNameById(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map=new HashMap<>();
        String page=userService.getNameById(Long.valueOf(request.getParameter("id")));
        map.put("data", page);
        return RtnResult.Success(map);
    } 
    
    
    @RequestMapping("/testAjax")
    @ResponseBody
    public RtnResult testAjax(HttpServletRequest request,User user){
    	Map<String, Object> map=new HashMap<String, Object>();
    	String name=request.getParameter("userName");
    	map.put("code", name);
    	return RtnResult.Success(map);
    }
    
   
    
    // 查询数据
    @RequestMapping("list")
    @ResponseBody
    public RtnResult list(HttpServletResponse response, HttpServletRequest request){
        redisCache.hsetTime("user3", "name3", "黄智3", 20);
        redisCache.sValueTime("user4", "name4", 30);
        String re=redisCache.hget("user3", "name3");
        try {
            this.write(response, re);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RtnResult.Success();
    }
    
    /**
     * 回写到页面上
     * @param response
     * @param o
     * @throws Exception
     */
    private void write(HttpServletResponse response, Object o) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
          
       
         
    
}