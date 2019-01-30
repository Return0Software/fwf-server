package io.r0s.fwf.domain.edges;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.Playlist;
import io.r0s.fwf.domain.nodes.User;

@RelationshipEntity(type = "FOLLOWS")
public final class Follow extends Entity {
	@StartNode
	private User user;

	@EndNode
	private Playlist playlist;

	private Role role;
	private Date since;

	public enum Role {
		AUTHOR, ADMIN, FOLLOWER
	}

	public Follow() {
	}

	public Role getRole() {
		return this.role;
	}

	public Date getSince() {
		return this.since;
	}

	public Playlist getPlaylist() {
		return this.playlist;
	}

	public User getUser() {
		return this.user;
	}
}
