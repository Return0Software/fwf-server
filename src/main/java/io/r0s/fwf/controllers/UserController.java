package io.r0s.fwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.UserService;

@RestController
@RequestMapping(path = "/users")
public final class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = { RequestMethod.GET })
	public String hello() {
		return "Hello user controller";
	}
}
