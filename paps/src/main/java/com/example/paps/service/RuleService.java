package com.example.paps.service;

import com.example.paps.dto.RuleForm;
import com.example.paps.model.Rule;
import com.example.paps.repo.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {
	RuleRepository ruleRepository;

	public RuleService(RuleRepository ruleRepository) {
		this.ruleRepository = ruleRepository;
	}

	public List<Rule> getRules() {
		List<Rule> rules = new ArrayList<>();
		ruleRepository.findAll().forEach(rules::add);
		return rules;
	}

	public Rule getRule(Long id) {
		if (ruleRepository.existsById(id)) {
			return ruleRepository.findById(id).get();
		} else {
			return null;
		}
	}

	public void addRule(RuleForm ruleForm) {
		Rule rule = new Rule();

		rule.setDescription(ruleForm.getDescription());
		rule.setParameters(ruleForm.getParameters());

		ruleRepository.save(rule);
	}

	public void modifyRule(Long id, RuleForm form) {
		if (ruleRepository.existsById(id)) {
			Rule rule = ruleRepository.findById(id).get();

			rule.setDescription(form.getDescription());
			rule.setParameters(form.getParameters());

			ruleRepository.save(rule);
		}
	}

	public void deleteRule(Long id) {
		ruleRepository.deleteById(id);
	}
}
