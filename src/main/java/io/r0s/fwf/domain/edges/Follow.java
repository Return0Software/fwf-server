package io.r0s.fwf.domain.edges;

import java.util.Date;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.List;
import io.r0s.fwf.domain.nodes.User;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "FOLLOWS")
public final class Follow extends Entity {
	@StartNode
	private User user;

	@EndNode
	private List list;

	private Role role;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public enum Role {
		AUTHOR, ADMIN, FOLLOWER
	}

	public Follow() {
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

	public List getList() {
		return this.list;
	}

	public User getUser() {
		return this.user;
	}
}
