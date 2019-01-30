package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.WatchlistService;

@RestController
@RequestMapping(path = "/watchlists")
public final class WatchlistController {
	private final WatchlistService watchlistService;

	public WatchlistController(final WatchlistService watchlistService) {
		this.watchlistService = watchlistService;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String requestMethodName() {
		return "Hello Watchlist controller";
	}
}
