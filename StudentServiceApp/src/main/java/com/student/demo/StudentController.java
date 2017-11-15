package com.student.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class StudentController {

	@Value("${msg:Hello world - Config Server is not working..please check}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}

	@RequestMapping(value = "/getStudentName", method = RequestMethod.GET)
	public String getStudentName() {
		return "Ankit";
	}

}
