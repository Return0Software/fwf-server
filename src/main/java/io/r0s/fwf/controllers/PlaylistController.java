package io.r0s.fwf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.r0s.fwf.services.PlaylistService;

@RestController
@RequestMapping(path = "/playlists")
public final class PlaylistController {
	private final PlaylistService playlistService;

	public PlaylistController(final PlaylistService playlistService) {
		this.playlistService = playlistService;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String requestMethodName() {
		return "Hello Playlist controller";
	}
}
