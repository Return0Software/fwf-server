package com.github.return0software.fwf.services;

import com.github.return0software.fwf.domain.nodes.List;

public class ListService extends GenericService<List> implements IListService {
	@Override
	protected Class<List> getEntityType() {
		return List.class;
	}
}
