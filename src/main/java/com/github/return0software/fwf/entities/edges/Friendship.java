package com.github.return0software.fwf.entities.edges;

import java.util.Date;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.nodes.User;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "FRIENDS_WITH")
public class Friendship extends Entity {
	@DateString
	private Date since;

	@StartNode
	User user;

	@EndNode
	User friend;

	public Friendship() {
	}
}
