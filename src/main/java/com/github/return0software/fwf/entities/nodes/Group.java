package com.github.return0software.fwf.entities.nodes;

import java.util.Date;
import java.util.Set;

import com.github.return0software.fwf.entities.Entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public final class Group extends Entity {
	private String name;

	@Relationship(type = "MEMBER")
	private Set<User> members;

	@Relationship(type = "OWNS")
	private Set<List> lists;

	@DateLong
	Date createdAt;

	@DateLong
	Date updatedAt;

	public Group() {
	}
}
