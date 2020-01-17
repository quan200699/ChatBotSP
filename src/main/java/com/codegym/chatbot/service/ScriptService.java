package com.codegym.chatbot.service;

import com.codegym.chatbot.model.Script;

public interface ScriptService extends GeneralService<Script> {
    Iterable<Script> findAllByScript(Script script);

    Iterable<Script> findAllByScriptIsNull();

    Script findScriptByContent(String content);
}
