package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Include;

@NodeEntity
public final class Movie extends Entity {
	private long tmdbID;

	@Relationship(type = "INCLUDES", direction = Relationship.INCOMING)
	private Set<Include> lists;

	private Date createdAt;
	private Date updatedAt;

	public Movie() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}
}
