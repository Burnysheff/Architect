package com.example.paps.service;

import com.example.paps.dto.GroupForm;
import com.example.paps.dto.RuleForm;
import com.example.paps.model.Group;
import com.example.paps.model.Rule;
import com.example.paps.repo.GroupRepository;
import com.example.paps.repo.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
	GroupRepository groupRepository;
	RuleRepository ruleRepository;

	public GroupService(GroupRepository groupRepository, RuleRepository ruleRepository) {
		this.ruleRepository = ruleRepository;
		this.groupRepository = groupRepository;
	}

	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<>();
		groupRepository.findAll().forEach(groups::add);
		return groups;
	}

	public Group getGroup(Long id) {
		if (groupRepository.existsById(id)) {
			return groupRepository.findById(id).get();
		} else {
			return null;
		}
	}

	public void addGroup(GroupForm groupForm) {
		Group group = new Group();

		group.setDescription(groupForm.getDescription());
		group.setActive(groupForm.isActive());

		groupRepository.save(group);
	}

	public void modifyGroup(Long id, GroupForm groupForm) {
		if (groupRepository.existsById(id)) {
			Group group = groupRepository.findById(id).get();

			group.setDescription(group.getDescription());
			group.setActive(group.isActive());

			groupRepository.save(group);
		}
	}

	public void deleteGroup(Long id) {
		groupRepository.deleteById(id);
	}

	public void addRuleToGroup(Long groupId, List<Long> ruleIds) {
		if (groupRepository.existsById(groupId)) {
			Group group = groupRepository.findById(groupId).get();

			for (Long id : ruleIds) {
				Rule rule = ruleRepository.findById(id).get();
				group.getRules().add(rule);
			}

			groupRepository.save(group);
		}
	}

	public void deleteRuleFromGroup(Long groupId, List<Long> ruleIds) {
		if (groupRepository.existsById(groupId)) {
			Group group = groupRepository.findById(groupId).get();

			for (Long id : ruleIds) {
				Rule rule = ruleRepository.findById(id).get();
				group.getRules().remove(rule);
			}

			groupRepository.save(group);
		}
	}
}
