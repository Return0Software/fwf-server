package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.ListRepository;

@Service
public class ListService {
	private final ListRepository listRepository;

	public ListService(final ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
