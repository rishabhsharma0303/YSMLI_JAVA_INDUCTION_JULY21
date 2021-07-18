package com.bookapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

	@GetMapping(path = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path = "/hello")
	public @ResponseBody  String hello(@RequestParam(name = "name")String name) {
		System.out.println("hello ..."+name);
		return "hello"+ name;
	}
}

