package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.User;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class UserService extends GenericService<User> implements IUserService {
	@Inject
	public UserService(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<User> getEntityType() {
		return User.class;
	}
}
