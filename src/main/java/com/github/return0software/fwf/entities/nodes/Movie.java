package com.github.return0software.fwf.entities.nodes;

import com.github.return0software.fwf.entities.Entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public final class Movie extends Entity {
	public Long tmdbID;
}
