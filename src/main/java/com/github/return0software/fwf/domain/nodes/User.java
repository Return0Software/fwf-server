package com.github.return0software.fwf.domain.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.edges.Follow;
import com.github.return0software.fwf.domain.edges.Friendship;
import com.github.return0software.fwf.domain.edges.Membership;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public final class User extends Entity {
	private String name;

	@Relationship(type = "FRIENDS_WITH", direction = Relationship.UNDIRECTED)
	private Set<Friendship> friends = new HashSet<>();

	@Relationship(type = "FOLLOWS", direction = Relationship.UNDIRECTED)
	private Set<Follow> lists = new HashSet<>();

	@Relationship(type = "MEMBER_OF", direction = Relationship.UNDIRECTED)
	private Set<Membership> groups = new HashSet<>();

	@DateLong
	private Date createdAt;

	@DateLong
	private Date updatedAt;

	public User() {
	}
}
