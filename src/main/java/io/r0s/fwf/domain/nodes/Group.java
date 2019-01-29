package io.r0s.fwf.domain.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.edges.Membership;

@NodeEntity
public final class Group extends Entity {
	private String name;

	@Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
	private Set<Membership> members;

	@Relationship(type = "OWNS", direction = Relationship.OUTGOING)
	private Set<List> lists;

	@DateString
	private Date createdAt;

	@DateString
	private Date updatedAt;

	public Group() {
	}
}
