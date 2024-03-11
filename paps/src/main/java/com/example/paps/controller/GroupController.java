package com.example.paps.controller;

import com.example.paps.dto.GroupForm;
import com.example.paps.dto.RuleForm;
import com.example.paps.model.Group;
import com.example.paps.model.Rule;
import com.example.paps.service.GroupService;
import com.example.paps.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
	GroupService groupService;

	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@GetMapping("/")
	public List<Group> getGroups() {
		return groupService.getGroups();
	}

	@GetMapping("/{id}")
	public Group getGroup(@PathVariable Long id) {
		return groupService.getGroup(id);
	}

	@PostMapping("/")
	public ResponseEntity<String> addGroup(@RequestBody GroupForm groupForm) {
		groupService.addGroup(groupForm);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> modifyGroup(@PathVariable Long id, @RequestBody GroupForm groupForm) {
		groupService.modifyGroup(id, groupForm);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
		groupService.deleteGroup(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}/add-rules")
	public ResponseEntity<String> addRulesToGroup(@PathVariable Long id, @RequestParam List<Long> rules) {
		groupService.addRuleToGroup(id, rules);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}/delete-rules")
	public ResponseEntity<String> deleteRulesFromGroup(@PathVariable Long id, @RequestParam List<Long> rules) {
		groupService.deleteRuleFromGroup(id, rules);
		return ResponseEntity.ok().build();
	}
}
