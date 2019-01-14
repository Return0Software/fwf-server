package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.Group;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class GroupService extends GenericService<Group> implements IGroupService {
	@Inject
	public GroupService(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<Group> getEntityType() {
		return Group.class;
	}
}
