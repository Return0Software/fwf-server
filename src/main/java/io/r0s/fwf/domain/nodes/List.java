package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Follow;
import io.r0s.fwf.domain.edges.Include;

@NodeEntity
public final class List extends Entity {
	private String name;

	@Relationship(type = "FOLLOWS", direction = Relationship.INCOMING)
	private Set<Follow> followers;

	@Relationship(type = "INCLUDES", direction = Relationship.OUTGOING)
	private Set<Include> movies;

	private boolean isPrivate;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public List() {
	}
}
