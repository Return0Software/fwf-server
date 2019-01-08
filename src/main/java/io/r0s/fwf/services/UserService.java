package io.r0s.fwf.services;

import io.r0s.fwf.domain.nodes.User;

public class UserService extends GenericService<User> implements IUserService {
	@Override
	protected Class<User> getEntityType() {
		return User.class;
	}
}
