package com.school.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SchoolService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callHystrixFallBack")
	public String getStudentName(){
		return restTemplate.getForObject("http://student-service/getStudentName",String.class);
	}
	
	private String callHystrixFallBack() {
      return "Exception occured !!! Proceeding...";
    }

}
