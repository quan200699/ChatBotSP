package com.codegym.chatbot.service.impl;

import com.codegym.chatbot.model.Script;
import com.codegym.chatbot.repository.ScriptRepository;
import com.codegym.chatbot.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScriptServiceImpl implements ScriptService {
    @Autowired
    private ScriptRepository scriptRepository;

    @Override
    public Iterable<Script> findAll() {
        return scriptRepository.findAll();
    }

    @Override
    public void save(Script script) {
        scriptRepository.save(script);
    }

    @Override
    public void delete(Long id) {
        scriptRepository.deleteById(id);
    }

    @Override
    public Optional<Script> findById(Long id) {
        return scriptRepository.findById(id);
    }

    @Override
    public Iterable<Script> findAllByScript(Script script) {
        return scriptRepository.findAllByScript(script);
    }

    @Override
    public Iterable<Script> findAllByScriptIsNull() {
        return scriptRepository.findAllByScriptIsNull();
    }

    @Override
    public Script findScriptByContent(String content) {
        return scriptRepository.findScriptByContent(content);
    }
}
