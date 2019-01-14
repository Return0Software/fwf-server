package io.r0s.fwf.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.r0s.fwf.services.UserService;

@Path("/users")
public final class UserResource {
	final UserService userService;

	@Inject
	public UserResource(final UserService userService) {
		this.userService = userService;
	}

	@GET
	public String hello() {
		return "Hello World";
	}
}
