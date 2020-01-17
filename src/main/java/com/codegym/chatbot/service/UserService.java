package com.codegym.chatbot.service;

import com.codegym.chatbot.model.User;

public interface UserService extends GeneralService<User> {
    Iterable<User> findAllByStatusIsTrue();

    Iterable<User> findAllByStatusIsFalse();

}