package com.codegym.chatbot.service.impl;

import com.codegym.chatbot.model.User;
import com.codegym.chatbot.repository.UserRepository;
import com.codegym.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAllByStatusIsTrue() {
        return userRepository.findAllByStatusIsTrue();
    }

    @Override
    public Iterable<User> findAllByStatusIsFalse() {
        return userRepository.findAllByStatusIsFalse();
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
