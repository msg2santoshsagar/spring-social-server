package com.sagar.springsocialserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore // Swagger will ignore this API
@Controller
public class RouteController {


	@RequestMapping(value = "/{[path:[^\\.]*}")
	public String redirect() {
		return "forward:/";
	}


}
