package io.r0s.fwf.domain.edges;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import io.r0s.fwf.domain.Entity;
import io.r0s.fwf.domain.nodes.Movie;
import io.r0s.fwf.domain.nodes.Playlist;
import io.r0s.fwf.domain.nodes.User;

@RelationshipEntity(type = "INCLUDES")
public class Include extends Entity {
	@DateString
	private Date since;

	private User addedBy;

	@StartNode
	private Playlist playlist;

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
