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
@Table(name = "rule")
@Entity
public class Rule {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="rule_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "parameters")
    @ElementCollection
    private List<Integer> parameters;
}
