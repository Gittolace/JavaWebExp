package com.giotto.javaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giotto.javaweb.bean.Commodity;
import com.giotto.javaweb.bean.Order;
import com.giotto.javaweb.bean.Result;
import com.giotto.javaweb.bean.User;
import com.giotto.javaweb.mapper.UserMapper;




@Service

@Transactional(rollbackFor = RuntimeException.class)

public class UserService {

	 @Autowired

	    private UserMapper userMapper;

	    /**

	     * 注册

	     * @param user 参数封装

	     * @return Result

	     */

	    public Result regist(User user) {

	        Result result = new Result();

	        result.setSuccess(false);

	        result.setDetail(null);

	        try {

	            User existUser = userMapper.findUserByName(user.getUsername());

	            if(existUser != null){

	                //如果用户名已存在

	                result.setMsg("用户名已存在");

	 

	            }
	            else if(user.getUsertype().equals("商家")||user.getUsertype().equals("用户"))
	            {
	            	userMapper.regist(user);
	                
	                result.setMsg("注册成功");

	                result.setSuccess(true);

	                result.setDetail(user);
	            }
	            else{

	            	result.setMsg("注册失败，用户种类只可填商家和用户其中之一");

	                result.setSuccess(false);

	            }

	        } catch (Exception e) {

	            result.setMsg(e.getMessage());

	            e.printStackTrace();

	        }

	        return result;

	    }

	    /**

	     * 登录

	     * @param user 用户名和密码

	     * @return Result

	     */

	    public Result login(User user) {

	        Result result = new Result();

	        result.setSuccess(false);

	        result.setDetail(null);

	        try {

	            Long userId= userMapper.login(user);

	            if(userId == null){

	                result.setMsg("用户名或密码错误");

	            }else{

	                result.setMsg("登录成功");

	                result.setSuccess(true);

	                user.setUserid(userId);
	                
	                String type=userMapper.getType(user);
	                
	                user.setUsertype(type);

	                result.setDetail(user);

	            }

	        } catch (Exception e) {

	            result.setMsg(e.getMessage());

	            e.printStackTrace();

	        }

	        return result;

	    }
	    
	    public Result getUser(User user)
	    {
	    	 Result result = new Result();

	         result.setSuccess(false);

	         result.setDetail(null);

	         try {

	             Long userId= userMapper.getId(user);

	             

	             result.setMsg("登录成功");

	             result.setSuccess(true);

	             user.setUserid(userId);
	             
	             String password=userMapper.getPassword(user);
	             
	             user.setPassword(password);
	             
	             result.setDetail(user);

	             

	         } catch (Exception e) {

	             result.setMsg(e.getMessage());

	             e.printStackTrace();

	         }

	         return result;
	    }
	    
	    
	    
	    public void newCommodity(Commodity commodity)
	    {
	    	userMapper.newCommodity(commodity);
	    }
	    
	    
	    public List<Commodity>getMyCommodity(User user)
	    {
	    	return userMapper.getMyCom(user);
	    }
	    
	    public List<Commodity>getCommodity()
	    {
	    	return userMapper.getCom();
	    }
	    
	    public List<Commodity> getComById(Commodity com)
	    {
	    	return userMapper.getComByid(com);
	    }
	    public void newOrder(Order order)
	    {
	    	userMapper.newOrder(order);
	    }
	    
	    public List<Order> getBuyerOrder(User user)
	    {
	    	return userMapper.getBuyerOrder(user);
	    }
	    
	    public List<Order> getDealOrder(User user)
	    {
	    	return userMapper.getDealOrder(user);
	    }
	    
	    public void deliverStatus(Order order)
	    {
	    	userMapper.deliverStatus(order);
	    }
	    
	    public void getConfirm(Order order)
	    {
	    	userMapper.getConfirm(order);
	    }
	    
	    public void deleteCom(Commodity com)
	    {
	    	userMapper.deletecom(com);
	    }
}

