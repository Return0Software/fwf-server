package io.r0s.fwf.services;

import io.r0s.fwf.domain.nodes.List;

public class ListService extends GenericService<List> implements IListService {
	@Override
	protected Class<List> getEntityType() {
		return List.class;
	}
}
