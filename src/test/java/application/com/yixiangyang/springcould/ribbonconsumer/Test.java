package application.com.yixiangyang.springcould.ribbonconsumer;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;



public class Test {
	
	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		JSONObject json = template.getForObject("http://localhost:9000/ribbon-consumer1", JSONObject.class);
		
		System.out.println(json);

	}

}
