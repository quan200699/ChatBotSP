package com.codegym.chatbot.repository;

import com.codegym.chatbot.model.Script;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScriptRepository extends JpaRepository<Script, Long> {
    Iterable<Script> findAllByScriptIsNull();

    Iterable<Script> findAllByScript(Script script);

    Script findScriptByContent(String content);
}
