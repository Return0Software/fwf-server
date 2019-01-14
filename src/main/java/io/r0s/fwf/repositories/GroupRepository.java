package io.r0s.fwf.repositories;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.Group;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class GroupRepository extends GenericRepository<Group> implements IGroupRepository {
	@Inject
	public GroupRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Group> getEntityType() {
		return Group.class;
	}
}
