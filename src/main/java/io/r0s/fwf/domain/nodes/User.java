package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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
	private Set<Follow> Playlists;

	@Relationship(type = "MEMBER_OF", direction = Relationship.OUTGOING)
	private Set<Membership> groups;

	private Date createdAt;
	private Date updatedAt;

	public User() {
	}

	public String getName() {
		return this.name;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}
}
