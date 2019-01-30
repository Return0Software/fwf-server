package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Membership;

@NodeEntity
public final class Group extends Entity {
	private String name;

	@Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
	private Set<Membership> members;

	@Relationship(type = "OWNS", direction = Relationship.OUTGOING)
	private Set<Playlist> Playlists;

	private Date createdAt;
	private Date updatedAt;

	public Group() {
	}
}
