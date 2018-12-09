package com.github.return0software.fwf.entities.nodes;

import java.util.Date;
import java.util.Set;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.edges.ListRole;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public final class List extends Entity {
	private String name;

	@Relationship(type = "FOLLOWS", direction = Relationship.INCOMING)
	private Set<ListRole> followers;

	@DateLong
	Date createdAt;

	@DateLong
	Date updatedAt;

	public List() {
	}
}
