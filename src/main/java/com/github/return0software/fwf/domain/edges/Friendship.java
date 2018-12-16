package com.github.return0software.fwf.domain.edges;

import java.util.Date;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.nodes.User;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "FRIENDS_WITH")
public class Friendship extends Entity {
	@DateString
	private Date since;

	@StartNode
	private User user;

	@EndNode
	private User friend;

	public Friendship() {
	}
}
