package io.r0s.fwf.services;

import io.r0s.fwf.domain.nodes.Group;

public class GroupService extends GenericService<Group> implements IGroupService {
	@Override
	protected Class<Group> getEntityType() {
		return Group.class;
	}
}
