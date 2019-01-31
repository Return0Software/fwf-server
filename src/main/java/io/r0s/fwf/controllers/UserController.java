package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.models.responses.UserResponse;
import io.r0s.fwf.services.UserService;

@RestController
@RequestMapping(path = "/users")
public final class UserController {
	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET })
	public UserResponse getUserById(@PathVariable("id") final Long id) {
		return new UserResponse();
	}
}
