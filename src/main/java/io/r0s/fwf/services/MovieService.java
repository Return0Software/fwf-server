package io.r0s.fwf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
}
