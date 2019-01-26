package io.r0s.fwf.repositories;

import org.neo4j.ogm.session.Session;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.factories.Neo4jSessionFactory;

abstract class GenericRepository<T extends Entity> implements IRepository<T> {

	// These 2 values should be paid a lot of attention to
	private static final int DEPTH_LIST = 0;
	private static final int DEPTH_ENTITY = 1;

	protected Session session;

	protected GenericRepository(final Neo4jSessionFactory sessionFactory) {
		this.session = sessionFactory.getSession();
	}

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
