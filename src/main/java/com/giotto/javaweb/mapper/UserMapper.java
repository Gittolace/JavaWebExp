package com.giotto.javaweb.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giotto.javaweb.bean.Commodity;
import com.giotto.javaweb.bean.Order;
import com.giotto.javaweb.bean.User;




@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描

@Repository
public interface UserMapper {
	
	  @Select(value = "select u.username,u.password from user u where u.username=#{username}")

	    @Results

	            ({@Result(property = "username",column = "username"),

	              @Result(property = "password",column = "password")})

	    User findUserByName(@Param("username") String username);



	    @Insert("insert into user values(#{userid},#{username},#{password},#{usertype})")

	    @Options(useGeneratedKeys = true,keyProperty = "userid",keyColumn = "userid")

	    void regist(User user);

	    
	    @Select("select u.userid from user u where u.username = #{username} and password = #{password}")
	    Long login(User user);
	    
	    @Select("select u.usertype from user u where u.username = #{username} and password = #{password}")

	    String getType(User user);
	    

	    @Insert("insert into commodity values(#{comid},#{comname},#{ownmanid},#{details},#{comtype},#{price})")

	    @Options(useGeneratedKeys = true,keyProperty = "comid",keyColumn = "comid")

	    void newCommodity(Commodity commodity);
	    
	    
	    @Select("select u.userid from user u where u.username = #{username} and usertype = #{usertype}")

	    Long getId(User user);
	    
	    @Select("select u.password from user u where u.username = #{username}")

	    String getPassword(User user);
	    
	    
	    
	    @Select("select * from commodity c where c.ownmanid = #{userid}")

	    List<Commodity> getMyCom(User user);
	    
	    @Select("select * from commodity")

	    List<Commodity> getCom();
	    
	    @Select("select * from commodity c where c.comid=#{comid}")

	    List<Commodity> getComByid(Commodity com);
	    
	    @Insert("insert into orderTable values(#{orderid},#{comname},#{comid},#{buyerid},#{num},#{total},#{status},#{raddress},#{rman},#{remail},#{rphone},#{date})")

	    @Options(useGeneratedKeys = true,keyProperty = "orderid",keyColumn = "orderid")

	    void newOrder(Order order);
	    
	    
	    @Select("select * from orderTable o where o.buyerid=#{userid}")

	    List<Order> getBuyerOrder(User user);
	    
	    @Select("select * from orderTable o where o.comid in (select comid from commodity c where c.ownmanid=#{userid})")

	    List<Order> getDealOrder(User user);
	    
	    
	    @Update("Update orderTable set status=#{status} where orderid= #{orderid} and status!='已完成'")

	    void deliverStatus(Order order);
	    
	    
	    @Update("Update orderTable set status=#{status} where orderid= #{orderid} and status!='未发货'")

	    void getConfirm(Order order);
	    
	    @Delete("Delete from commodity where comid=#{comid}")
	    void deletecom(Commodity commodity);
	    
	    
}
