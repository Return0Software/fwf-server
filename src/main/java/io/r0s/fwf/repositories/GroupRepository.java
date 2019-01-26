package io.r0s.fwf.repositories;

import org.springframework.stereotype.Repository;

import io.r0s.fwf.domain.nodes.Group;
import io.r0s.fwf.factories.Neo4jSessionFactory;

@Repository
public class GroupRepository extends GenericRepository<Group> implements IGroupRepository {
	public GroupRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Group> getEntityType() {
		return Group.class;
	}
}
