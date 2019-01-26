package io.r0s.fwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.ListService;

@RestController
@RequestMapping(path = "/lists")
public final class ListController {
	@Autowired
	private ListService listService;

	@RequestMapping(method = { RequestMethod.GET })
	public String requestMethodName() {
		return "Hello list controller";
	}

}
