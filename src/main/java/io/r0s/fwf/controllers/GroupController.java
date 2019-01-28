package io.r0s.fwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.GroupService;

@RestController
@RequestMapping(path = "/groups")
public final class GroupController {
	@Autowired
	private GroupService groupService;

	@RequestMapping(method = { RequestMethod.GET })
	public String World() {
		return "Hello group controller";
	}
}