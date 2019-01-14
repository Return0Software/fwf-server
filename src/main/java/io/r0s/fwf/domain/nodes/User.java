package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Follow;
import io.r0s.fwf.domain.edges.Friendship;
import io.r0s.fwf.domain.edges.Membership;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@NodeEntity
public final class User extends Entity {
	private String name;

	@Relationship(type = "FRIENDS_WITH", direction = Relationship.UNDIRECTED)
	private Set<Friendship> friends = new HashSet<>();

	@Relationship(type = "FOLLOWS", direction = Relationship.OUTGOING)
	private Set<Follow> lists = new HashSet<>();

	@Relationship(type = "MEMBER_OF", direction = Relationship.OUTGOING)
	private Set<Membership> groups = new HashSet<>();

	@DateLong
	private Date createdAt;

	@DateLong
	private Date updatedAt;

	public User() {
	}
}
