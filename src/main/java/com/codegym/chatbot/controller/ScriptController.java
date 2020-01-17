package com.codegym.chatbot.controller;

import com.codegym.chatbot.model.Script;
import com.codegym.chatbot.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ScriptController {
    @Autowired
    private ScriptService scriptService;

    @GetMapping("/scripts")
    public ResponseEntity<Iterable<Script>> findAll() {
        Iterable<Script> scripts = scriptService.findAll();
        return new ResponseEntity<>(scripts, HttpStatus.OK);
    }

    @PostMapping("/scripts")
    public ResponseEntity<Script> createScript(@RequestBody Script script) {
        scriptService.save(script);
        return new ResponseEntity<>(script, HttpStatus.CREATED);
    }

    @PutMapping("/scripts/{id}")
    public ResponseEntity<Script> updateScript(@PathVariable Long id, @RequestBody Script script) {
        Optional<Script> scriptOptional = scriptService.findById(id);
        if (scriptOptional.isPresent()) {
            scriptService.save(scriptOptional.get());
            return new ResponseEntity<>(scriptOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/scripts/{id}")
    public ResponseEntity<Script> deleteScript(@PathVariable Long id) {
        Optional<Script> scriptOptional = scriptService.findById(id);
        if (scriptOptional.isPresent()) {
            scriptService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
