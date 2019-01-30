package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.PlaylistRepository;

@Service
public class PlaylistService {
	private final PlaylistRepository playlistRepository;

	public PlaylistService(final PlaylistRepository PlaylistRepository) {
		this.playlistRepository = PlaylistRepository;
	}
}
