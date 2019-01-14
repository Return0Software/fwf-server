package io.r0s.fwf.domain.edges;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.User;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
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

	public Date getSince() {
		return this.since;
	}
}
