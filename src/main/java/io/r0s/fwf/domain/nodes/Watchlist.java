package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Follow;
import io.r0s.fwf.domain.edges.Include;

@NodeEntity
public final class Watchlist extends Entity {
	private String name;

	@Relationship(type = "FOLLOWS", direction = Relationship.INCOMING)
	private Set<Follow> followers;

	@Relationship(type = "INCLUDES", direction = Relationship.OUTGOING)
	private Set<Include> movies;

	private Boolean isPrivate;
	private Date createdAt;
	private Date updatedAt;

	public Watchlist() {
	}

	public String getName() {
		return this.name;
	}

	public boolean isPrivate() {
		return this.isPrivate;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}
}
