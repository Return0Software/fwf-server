package com.github.return0software.fwf.services;

import com.github.return0software.fwf.domain.nodes.User;

public class UserService extends GenericService<User> implements IUserService {
	@Override
	protected Class<User> getEntityType() {
		return User.class;
	}
}
