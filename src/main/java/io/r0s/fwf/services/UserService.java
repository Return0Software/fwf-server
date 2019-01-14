package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.repositories.UserRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
public class UserService {
	private final UserRepository userRepository;

	@Inject
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
