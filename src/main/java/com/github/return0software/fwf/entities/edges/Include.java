package com.github.return0software.fwf.entities.edges;

import java.util.Date;

import com.github.return0software.fwf.entities.Entity;
import com.github.return0software.fwf.entities.nodes.List;
import com.github.return0software.fwf.entities.nodes.Movie;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@RelationshipEntity(type = "INCLUDES")
public class Include extends Entity {
	@DateString
	Date since;

	@StartNode
	List list;

	@EndNode
	Movie movie;
}
