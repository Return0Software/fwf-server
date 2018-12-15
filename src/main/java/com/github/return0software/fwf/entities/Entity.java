package com.github.return0software.fwf.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class Entity {
	@Id
	@GeneratedValue
	protected Long id;

	public Long getID() {
		return this.id;
	}
}
