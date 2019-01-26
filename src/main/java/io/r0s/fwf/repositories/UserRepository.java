package io.r0s.fwf.repositories;

import org.springframework.stereotype.Repository;

import io.r0s.fwf.domain.nodes.User;
import io.r0s.fwf.factories.Neo4jSessionFactory;

@Repository
public class UserRepository extends GenericRepository<User> implements IUserRepository {
	public UserRepository(final Neo4jSessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	protected Class<User> getEntityType() {
		return User.class;
	}
}
