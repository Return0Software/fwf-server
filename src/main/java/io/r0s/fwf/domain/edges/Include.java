package io.r0s.fwf.domain.edges;

import java.util.Date;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.List;
import io.r0s.fwf.domain.nodes.Movie;
import io.r0s.fwf.domain.nodes.User;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "INCLUDES")
public class Include extends Entity {
	@DateString
	private Date since;

	private User addedBy;

	@StartNode
	private List list;

	@EndNode
	private Movie movie;

	public Include() {
	}

	public Date getSince() {
		return this.since;
	}

	public User getAddedBy() {
		return this.addedBy;
	}
}