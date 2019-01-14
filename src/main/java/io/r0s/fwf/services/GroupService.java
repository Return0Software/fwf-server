package io.r0s.fwf.services;

import javax.inject.Inject;

import io.r0s.fwf.repositories.GroupRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
public class GroupService {
	private final GroupRepository groupRepository;

	@Inject
	public GroupService(final GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
}
