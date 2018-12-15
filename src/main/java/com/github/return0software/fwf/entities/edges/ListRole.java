package com.github.return0software.fwf.entities.edges;

import java.util.Date;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.nodes.List;

import org.eclipse.jetty.server.Authentication.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "FOLLOWS")
public final class ListRole extends Entity {
	@StartNode
	User user;

	@EndNode
	List list;

	Role role;

	@DateString
	Date createdAt;

	@DateString
	Date updatedAt;

	enum Role {
		AUTHOR, ADMIN, FOLLOWER
	}

	public ListRole() {
	}
}
