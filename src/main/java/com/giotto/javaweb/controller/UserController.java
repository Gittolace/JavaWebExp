package com.giotto.javaweb.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giotto.javaweb.bean.Commodity;
import com.giotto.javaweb.bean.Order;
import com.giotto.javaweb.bean.Result;
import com.giotto.javaweb.bean.User;
import com.giotto.javaweb.service.UserService;

import io.swagger.annotations.Api;



@Controller    //相当于@Controller+@RequestBody
@Api(value = "UserController ")
@RequestMapping("/user")
public class UserController {

 

    @Autowired

    private UserService userService;
    


    @PostMapping(value = "/regist",produces="application/json;charset=UTF-8")
    public String regist(User user,Model model){
    	
        Result r=userService.regist(user);
        model.addAttribute("msg", r.getMsg());
        return "registResult";
    }


    @PostMapping(value = "/login",produces="application/json;charset=UTF-8")
    public String login(User user,Model model){

    	Result r=userService.login(user);
    	if(r.getSuccess())
    	{
        	model.addAttribute("u", user);
        	if(user.getUsertype().equals("商家"))
        	{
                return "BusinessPage";
        	}

        	else
        	{
        		return "BuyerPage";
        	}
    	}
    	else
    	{
    		return "WrongPassword";
    	}
        

    }
    
    @PostMapping(value = "/newcommoditypage",produces="application/json;charset=UTF-8")
    public String newcommoditypage(User user,Model model){

    	Result r=userService.getUser(user);
    	
    	model.addAttribute("u", user);
    	
    	return "NewCommodity";
        

    }
    
    @PostMapping(value = "/newcommodity",produces="application/json;charset=UTF-8")
    public String newcommodity(User user,Commodity commodity,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	userService.newCommodity(commodity);
    	return "BusinessPage";
        

    }
    
    @PostMapping(value = "/mycommodity",produces="application/json;charset=UTF-8")
    public String mycommodity(User user,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	List<Commodity>com=userService.getMyCommodity(user);
    	model.addAttribute("com", com);
    	return "Mycommodity";
        

    }
    
    @PostMapping(value = "/buypage",produces="application/json;charset=UTF-8")
    public String buypage(User user,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	List<Commodity>com=userService.getCommodity();
    	model.addAttribute("com", com);
    	return "BuyPage";
        

    }
    
    @PostMapping(value = "/paypage",produces="application/json;charset=UTF-8")
    public String paypage(User user,Commodity c,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	List<Commodity>com=userService.getComById(c);
    	model.addAttribute("com", com);
    	return "PayPage";
        

    }
    
    @PostMapping(value = "/pay",produces="application/json;charset=UTF-8")
    public String pay(User user,Commodity c,Order order,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	
    	List<Commodity>com=userService.getComById(c);
    	
    	
    	Timestamp d = new Timestamp(System.currentTimeMillis()); 
    	
    	order.setTotal(order.getNum()*com.get(0).getPrice());
    	order.setDate(d);
    	
    	userService.newOrder(order);
    	
    	return "paySucess";
        

    }
    
    @PostMapping(value = "/myorder",produces="application/json;charset=UTF-8")
    public String myorder(User user,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	
    	List<Order>o=userService.getBuyerOrder(user);
    	
    	model.addAttribute("order", o);
    	return "BuyerOrder";
        

    }
    
    @PostMapping(value = "/dealwith",produces="application/json;charset=UTF-8")
    public String dealwith(User user,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	
    	List<Order>o=userService.getDealOrder(user);
    	
    	model.addAttribute("order", o);
    	return "DealWithPage";
        

    }
    
    @PostMapping(value = "/deliver",produces="application/json;charset=UTF-8")
    public String deliver(User user,Order order,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	
    	userService.deliverStatus(order);
    	
    	List<Order>o=userService.getDealOrder(user);
    	
    	model.addAttribute("order", o);
    	
    	return "DealWithPage";
        

    }

    
    @PostMapping(value = "/getConfirm",produces="application/json;charset=UTF-8")
    public String getConfirm(User user,Order order,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	
    	userService.getConfirm(order);
    	
    	List<Order>o=userService.getBuyerOrder(user);
    	
    	model.addAttribute("order", o);
    	
    	return "BuyerOrder";
       
    }
    
    @PostMapping(value = "/deletecom",produces="application/json;charset=UTF-8")
    public String deletecom(User user,Commodity c,Model model){

    	Result r=userService.getUser(user);
    	model.addAttribute("u", user);
    	userService.deleteCom(c);
    	List<Commodity>com=userService.getMyCommodity(user);
    	model.addAttribute("com", com);
    	return "Mycommodity";
        

    }
}