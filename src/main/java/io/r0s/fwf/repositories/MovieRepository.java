package io.r0s.fwf.repositories;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.Movie;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class MovieRepository extends GenericRepository<Movie> implements IMovieRepository {
	@Inject
	public MovieRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Movie> getEntityType() {
		return Movie.class;
	}
}
