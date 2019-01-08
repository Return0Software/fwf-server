package io.r0s.fwf.services;

import io.r0s.fwf.domain.Entity;

interface Service<T extends Entity> {
	Iterable<T> findAll();

	T find(Long id);

	void delete(Long id);

	T save(T entity);
}
