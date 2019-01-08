package io.r0s.fwf.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.r0s.fwf.services.GroupService;

@Path("/groups")
public final class GroupResource {
	GroupService groupService;

	@Inject
	public GroupResource(GroupService groupService) {
		this.groupService = groupService;
	}

	@GET
	public String World() {
		return "Hello World";
	}
}
