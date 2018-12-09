package com.github.return0software.fwf.entities.nodes;

import java.util.Date;
import java.util.Set;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.edges.ListRole;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public final class User extends Entity {
	private String name;

	@Relationship(type = "FRIENDS_WITH")
	private Set<User> friends;

	@Relationship(type = "FOLLOWS")
	private Set<ListRole> lists;

	@DateLong
	Date createdAt;

	@DateLong
	Date updatedAt;

	public User() {
	}
}
