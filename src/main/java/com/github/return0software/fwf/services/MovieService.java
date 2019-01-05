package com.github.return0software.fwf.services;

import com.github.return0software.fwf.domain.nodes.Movie;

public class MovieService extends GenericService<Movie> implements IMovieService {
	@Override
	protected Class<Movie> getEntityType() {
		return Movie.class;
	}
}
