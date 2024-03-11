package com.example.paps.controller;

import com.example.paps.dto.RuleForm;
import com.example.paps.model.Rule;
import com.example.paps.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {
	RuleService ruleService;

	public RuleController(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	@GetMapping("/")
	public List<Rule> getRules() {
		return ruleService.getRules();
	}

	@GetMapping("/{id}")
	public Rule getRules(@PathVariable Long id) {
		return ruleService.getRule(id);
	}

	@PostMapping("/")
	public ResponseEntity<String> addRule(@RequestBody RuleForm ruleForm) {
		ruleService.addRule(ruleForm);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> modifyRule(@PathVariable Long id, @RequestBody RuleForm ruleForm) {
		ruleService.modifyRule(id, ruleForm);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRule(@PathVariable Long id) {
		ruleService.deleteRule(id);
		return ResponseEntity.ok().build();
	}
}
