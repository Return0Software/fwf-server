package com.github.return0software.fwf.domain.edges;

import java.util.Date;

import com.github.return0software.fwf.domain.Entity;
import com.github.return0software.fwf.domain.nodes.List;
import com.github.return0software.fwf.domain.nodes.Movie;
import com.github.return0software.fwf.domain.nodes.User;

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
}
