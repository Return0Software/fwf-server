package io.r0s.fwf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.UserRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
}
