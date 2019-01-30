package io.r0s.fwf.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import io.r0s.fwf.domain.nodes.Playlist;

@Repository
public interface PlaylistRepository extends Neo4jRepository<Playlist, Long> {
}
