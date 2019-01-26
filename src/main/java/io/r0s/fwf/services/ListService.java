package io.r0s.fwf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.ListRepository;

@Service
public class ListService {
	@Autowired
	private ListRepository listRepository;
}
