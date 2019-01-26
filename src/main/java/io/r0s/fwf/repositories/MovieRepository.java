package io.r0s.fwf.repositories;

import org.springframework.stereotype.Repository;

import io.r0s.fwf.domain.nodes.Movie;
import io.r0s.fwf.factories.Neo4jSessionFactory;

@Repository
public class MovieRepository extends GenericRepository<Movie> implements IMovieRepository {
	public MovieRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Movie> getEntityType() {
		return Movie.class;
	}
}
