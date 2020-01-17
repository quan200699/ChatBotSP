package com.codegym.chatbot.repository;

import com.codegym.chatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByStatusIsTrue();

    Iterable<User> findAllByStatusIsFalse();
}
