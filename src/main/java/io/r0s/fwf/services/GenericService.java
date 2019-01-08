package io.r0s.fwf.services;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.managed.Neo4jSessionFactory;

import org.neo4j.ogm.session.Session;

abstract class GenericService<T extends Entity> implements Service<T> {
	// These 2 values should be paid a lot of attention to
	private static final int DEPTH_LIST = 0;
	private static final int DEPTH_ENTITY = 1;

	protected Session session = Neo4jSessionFactory.getNeo4jSession();

	@Override
	public Iterable<T> findAll() {
		return session.loadAll(this.getEntityType(), DEPTH_LIST);
	}

	@Override
	public T find(Long id) {
		return session.load(this.getEntityType(), id);
	}

	@Override
	public void delete(Long id) {
		session.delete(session.load(this.getEntityType(), id));
	}

	@Override
	public T save(T entity) {
		session.save(entity, DEPTH_ENTITY);
		return find(entity.getID());
	}

	protected abstract Class<T> getEntityType();
}