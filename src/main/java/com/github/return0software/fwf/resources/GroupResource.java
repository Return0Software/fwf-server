package com.github.return0software.fwf.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/group")
public final class GroupResource {
	@GET
	public String World() {
		return "Hello World";
	}
}
