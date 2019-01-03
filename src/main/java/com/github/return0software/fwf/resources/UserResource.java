package com.github.return0software.fwf.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public final class UserResource {
	@GET
	public String hello() {
		return "Hello World";
	}
}
