package com.codegym.chatbot.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    void save(T t);

    void delete(Long id);

    Optional<T> findById(Long id);
}
