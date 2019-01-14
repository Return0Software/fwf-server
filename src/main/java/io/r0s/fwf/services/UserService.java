package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.repositories.UserRepository;

public class UserService {
	private final UserRepository UserRepository;

	@Inject
	public UserService(final UserRepository UserRepository) {
		this.UserRepository = UserRepository;
	}
}
