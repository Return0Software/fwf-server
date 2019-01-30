package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.WatchlistRepository;

@Service
public class WatchlistService {
	private final WatchlistRepository watchlistRepository;

	public WatchlistService(final WatchlistRepository WatchlistRepository) {
		this.watchlistRepository = WatchlistRepository;
	}
}
