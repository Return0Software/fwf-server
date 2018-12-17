package com.github.return0software.fwf.domain.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.edges.Follow;
import com.github.return0software.fwf.domain.edges.Include;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@NodeEntity
public final class List extends Entity {
	private String name;

	@Relationship(type = "FOLLOWS", direction = Relationship.INCOMING)
	private Set<Follow> followers;

	@Relationship(type = "INCLUDES", direction = Relationship.OUTGOING)
	private Set<Include> movies = new HashSet<>();

	private boolean isPrivate;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public List() {
	}
}
