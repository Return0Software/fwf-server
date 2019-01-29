package io.r0s.fwf.services;

import org.springframework.stereotype.Service;

import io.r0s.fwf.repositories.GroupRepository;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Service
public class GroupService {
	private final GroupRepository groupRepository;

	public GroupService(final GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
}
