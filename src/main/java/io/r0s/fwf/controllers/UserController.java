package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.UserService;

@RestController
@RequestMapping(path = "/users")
public final class UserController {
	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String hello() {
		return "Hello user controller";
	}
}
