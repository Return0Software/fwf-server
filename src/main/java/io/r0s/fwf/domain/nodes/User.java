package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Follow;
import io.r0s.fwf.domain.edges.Friendship;
import io.r0s.fwf.domain.edges.Membership;

@NodeEntity
public final class User extends Entity {
	private String name;

	@Relationship(type = "FRIENDS_WITH", direction = Relationship.UNDIRECTED)
	private Set<Friendship> friends;

	@Relationship(type = "FOLLOWS", direction = Relationship.OUTGOING)
	private Set<Follow> lists;

	@Relationship(type = "MEMBER_OF", direction = Relationship.OUTGOING)
	private Set<Membership> groups;

	@DateLong
	private Date createdAt;

	@DateLong
	private Date updatedAt;

	public User() {
	}
}
