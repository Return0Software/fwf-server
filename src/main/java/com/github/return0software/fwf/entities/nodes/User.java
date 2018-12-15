package com.github.return0software.fwf.entities.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.edges.Friendship;
import com.github.return0software.fwf.entities.edges.ListRole;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public final class User extends Entity {
	private String name;

	@Relationship(type = "FRIENDS_WITH", direction = Relationship.OUTGOING)
	private Set<Friendship> friends = new HashSet<>();

	@Relationship(type = "FOLLOWS", direction = Relationship.UNDIRECTED)
	private Set<ListRole> lists = new HashSet<>();

	@DateLong
	Date createdAt;

	@DateLong
	Date updatedAt;

	public User() {
	}
}
