package io.r0s.fwf.repositories;

import io.r0s.fwf.domain.Entity;

interface Repository<T extends Entity> {
	Iterable<T> findAll();

	T find(Long id);

	void delete(Long id);

	T save(T entity);
}
