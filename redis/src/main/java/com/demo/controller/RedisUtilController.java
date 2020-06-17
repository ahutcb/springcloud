package com.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constants.UserEntity;
import com.demo.util.RedisUtil;

@RestController
@RequestMapping(value = "/redisUtil")
public class RedisUtilController {

    private static int ExpireTime = 600;   // redis中存储的过期时间60s

	@Autowired
	private RedisUtil redisUtil;
	
	 @RequestMapping("/set")
	 public boolean redisset(String key, String value){
	        UserEntity userEntity =new UserEntity();
	        userEntity.setId(Long.valueOf(1));
	        userEntity.setGuid(String.valueOf(1));
	        userEntity.setName("zhangsan");
	        userEntity.setAge(String.valueOf(20));
	        userEntity.setCreateTime(new Date());
 	        return redisUtil.set(key,userEntity,ExpireTime);
 	        //return redisUtil.set(key,value);
    }	
	 @RequestMapping("/get")
	 public Object redisget(String key){
 	        return redisUtil.get(key);
	  }

    @RequestMapping("/expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
	
	
}
