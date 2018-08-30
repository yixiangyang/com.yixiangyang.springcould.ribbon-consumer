package com.yixiangyang.springcould.ribbon.consumer.application;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
	@Resource
	private RestTemplate template;
	
	@Resource
	private HelloService helloService;
	
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return helloService.helloService();
	}
	
	@RequestMapping(value="/ribbon-consumer1",method=RequestMethod.GET)
	public ResponseEntity<?> jsonTest() throws JSONException{
//		JSONObject json = new JSONObject();
//		json.put("aa", "aaaaaaa");
		Map<String, String> map1 = new HashMap<>();
		map1.put("aaaaaa", "ddddd");
		return new ResponseEntity<Object>(map1, HttpStatus.OK);
	}
}
