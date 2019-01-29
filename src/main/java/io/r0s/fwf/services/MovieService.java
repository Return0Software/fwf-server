package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepository;

	public MovieService(final MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
}
