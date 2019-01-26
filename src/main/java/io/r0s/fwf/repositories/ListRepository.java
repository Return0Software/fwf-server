package io.r0s.fwf.repositories;

import org.springframework.stereotype.Repository;

import io.r0s.fwf.domain.nodes.List;
import io.r0s.fwf.factories.Neo4jSessionFactory;

@Repository
public class ListRepository extends GenericRepository<List> implements IListRepository {
	public ListRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<List> getEntityType() {
		return List.class;
	}
}
