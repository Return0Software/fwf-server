package io.r0s.fwf.domain.edges;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.Group;
import io.r0s.fwf.domain.nodes.User;

@RelationshipEntity(type = "MEMBER_OF")
public final class Membership extends Entity {
	@StartNode
	private User user;

	@EndNode
	private Group group;

	private Role role;
	private Date createdAt;
	private Date updatedAt;

	enum Role {
		ADMIN, MEMBER
	}

	public Membership() {
	}

	public Role getRole() {
		return this.role;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public User getUser() {
		return this.user;
	}

	public Group getGroup() {
		return this.group;
	}
}
