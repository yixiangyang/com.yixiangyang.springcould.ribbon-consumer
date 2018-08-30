package com.yixiangyang.springcould.ribbon.consumer.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.exception.HystrixBadRequestException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback",ignoreExceptions = {HystrixBadRequestException.class})
	public String helloService(){
		
		return restTemplate.getForEntity("http://service-hystrix1/hello", String.class).getBody();
	}
	
	public String helloFallback(Throwable e){
		System.out.println(e.getMessage());
		return "error"+e.getMessage();
	}
}
