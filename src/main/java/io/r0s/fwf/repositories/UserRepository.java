package io.r0s.fwf.repositories;

import javax.inject.Inject;

import io.r0s.fwf.domain.nodes.User;
import io.r0s.fwf.managed.Neo4jSessionFactory;

public class UserRepository extends GenericRepository<User> implements IUserRepository {
	@Inject
	public UserRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<User> getEntityType() {
		return User.class;
	}
}
