package com.school.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class SchoolController {

	@Value("${msg:Hello world - Config Server is not working..Please check}")
	private String msg;

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(value = "/getStudentName", method = RequestMethod.GET)
	public String getStudentName() {
		return schoolService.getStudentName();

	}

	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public String getValue() {
		return this.msg;

	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
