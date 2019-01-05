package com.github.return0software.fwf.services;

import com.github.return0software.fwf.domain.nodes.Group;

public class GroupService extends GenericService<Group> implements IGroupService {
	@Override
	protected Class<Group> getEntityType() {
		return Group.class;
	}
}
