package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.MovieService;

@RestController
@RequestMapping(path = "/movies")
public final class MovieController {
	private MovieService movieService;

	public MovieController(final MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String requestMethodName() {
		return "Hello movie controller";
	}

}
