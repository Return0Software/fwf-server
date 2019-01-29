package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.UserRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
