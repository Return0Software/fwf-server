package io.r0s.fwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.MovieService;

@RestController
@RequestMapping(path = "/movies")
public final class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(method = { RequestMethod.GET })
	public String requestMethodName() {
		return "Hello movie controller";
	}

}
