package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.GroupService;

@RestController
@RequestMapping(path = "/groups")
public final class GroupController {
	private final GroupService groupService;

	public GroupController(final GroupService groupService) {
		this.groupService = groupService;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String World() {
		return "Hello group controller";
	}
}
