package com.github.return0software.fwf.domain.nodes;

import java.util.Date;
import java.util.Set;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.edges.Membership;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@NodeEntity
public final class Group extends Entity {
	private String name;

	@Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
	private Set<Membership> members;

	// @Relationship(type = "OWNS", direction = Relationship.OUTGOING)
	// private Set<List> lists = new HashSet<>();

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public Group() {
	}
}
