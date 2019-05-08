package com.example.arkadiusz.app.dao;

import com.example.arkadiusz.app.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>
    {
    @Override
    <S extends UserEntity> S save(S s);

    Optional<UserEntity> findUserById(Long id);

    Optional<UserEntity> findByLoginIs(String login);
    }
