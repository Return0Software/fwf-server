package io.r0s.fwf.services;

import io.r0s.fwf.domain.nodes.Movie;

public class MovieService extends GenericService<Movie> implements IMovieService {
	@Override
	protected Class<Movie> getEntityType() {
		return Movie.class;
	}
}
