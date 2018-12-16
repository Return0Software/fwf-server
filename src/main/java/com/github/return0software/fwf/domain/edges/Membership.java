package com.github.return0software.fwf.domain.edges;

import java.util.Date;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.nodes.Group;

import org.eclipse.jetty.server.Authentication.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

// @RelationshipEntity(type = "MEMBER_OF")
public final class Membership extends Entity {
	@StartNode
	private User user;

	@EndNode
	private Group group;

	private Role role;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	enum Role {
		ADMIN, MEMBER
	}

	public Membership() {
	}
}