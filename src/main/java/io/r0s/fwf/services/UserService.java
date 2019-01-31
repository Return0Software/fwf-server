package io.r0s.fwf.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.r0s.fwf.domain.nodes.User;
import io.r0s.fwf.repositories.UserRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(final long id) {
		return this.userRepository.findById(id);
	}

	public void deleteById(final long id) {
		this.userRepository.deleteById(id);
	}

	public void updateById(final long id) {
		this.userRepository.findById(id).ifPresent(user -> {
			log.info("Updating user: {}", id);
		});
	}

	public void create() {
		// this.userRepository.save(entity);
	}
}
