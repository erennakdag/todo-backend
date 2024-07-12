package com.erenn.todoapp.User;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username = ?2 WHERE u.ID = ?1")
    void updateUsernameByID(Long id, String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = ?2 WHERE u.ID = ?1")
    void updatePasswordByID(Long id, String newPasswordHash);
}
