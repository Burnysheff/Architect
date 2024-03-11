package com.example.paps.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rule_group")
@Entity
public class Group {
	@Id
	@GeneratedValue
	@NotNull
	@Column(name="rule_group_id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private boolean active;

	@OneToMany
	@Column(name = "rules")
	private List<Rule> rules;
}
