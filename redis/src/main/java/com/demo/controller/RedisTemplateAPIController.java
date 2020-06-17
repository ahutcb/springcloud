package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * spring 封装的redisTemplate和stringRedisTemplate 的原生API
 * @author kaifa004
 * url:https://blog.csdn.net/zn65786412qq/article/details/81224596
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
@RestController
@RequestMapping(value = "/redisApi")
public class RedisTemplateAPIController {

 	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	
	
	
	
	@RequestMapping("/test")
	public String test()throws Exception{
	 
	    
	    redisTemplate.opsForValue().set("A","B");
        System.out.println(redisTemplate.opsForValue().get("A"));
        
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("multi1","multi111");
        maps.put("multi2","multi222");
        maps.put("multi3","multi333");
        redisTemplate.opsForValue().multiSet(maps);
        List<String> keys = new ArrayList<String>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        System.out.println(redisTemplate.opsForValue().multiGet(keys));
        
        
        redisTemplate.opsForList().leftPush("list", "A");
        redisTemplate.opsForList().leftPush("list", "B");
        redisTemplate.opsForList().leftPush("list", "C");
        redisTemplate.opsForList().leftPush("list", "D");
        redisTemplate.opsForList().leftPush("list", "E");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        String[] stringarrays = new String[]{"1","2","3"};
        redisTemplate.opsForList().leftPushAll("listarray",stringarrays);
        System.out.println(redisTemplate.opsForList().range("listarray",0,-1));
        
        
        List<Object> strings = new ArrayList<Object>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        redisTemplate.opsForList().leftPushAll("listcollection4", strings);
        System.out.println(redisTemplate.opsForList().range("listcollection4",0,-1));

        
        System.out.println(redisTemplate.opsForList().leftPushIfPresent("leftPushIfPresent","aa"));
        System.out.println(redisTemplate.opsForList().leftPushIfPresent("leftPushIfPresent","bb"));
        System.out.println(redisTemplate.opsForList().leftPush("leftPushIfPresent","aa"));
        System.out.println(redisTemplate.opsForList().leftPushIfPresent("leftPushIfPresent","bb"));
        
        redisTemplate.opsForList().leftPush("list","A","AA");
        System.out.print(redisTemplate.opsForList().range("list",0,-1));
         
		return "test";
	}
}
