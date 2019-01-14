package io.r0s.fwf.repositories;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.List;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class ListRepository extends GenericRepository<List> implements IListRepository {
	@Inject
	public ListRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<List> getEntityType() {
		return List.class;
	}
}
