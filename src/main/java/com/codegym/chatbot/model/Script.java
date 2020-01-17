package com.codegym.chatbot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "farther_id")
    private Script script;

    @OneToMany(targetEntity = Script.class)
    private Set<Script> children = new HashSet<>();
}
