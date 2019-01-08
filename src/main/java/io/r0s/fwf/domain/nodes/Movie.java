package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Include;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@NodeEntity
public final class Movie extends Entity {
	private long tmdbID;

	@Relationship(type = "INCLUDES", direction = Relationship.INCOMING)
	private Set<Include> lists;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public Movie() {
	}
}