package com.github.return0software.fwf.services;

import com.github.return0software.fwf.domain.Entity;

interface Service<T extends Entity> {
	Iterable<T> findAll();

	T find(Long id);

	void delete(Long id);

	T save(T entity);
}
