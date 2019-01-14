package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.Movie;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class MovieService extends GenericService<Movie> implements IMovieService {
	@Inject
	public MovieService(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Movie> getEntityType() {
		return Movie.class;
	}
}
