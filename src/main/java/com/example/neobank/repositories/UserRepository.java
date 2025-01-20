package com.example.neobank.repositories;

import com.example.neobank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.balance WHERE u.username = :username")
    User findByUsernameWithBalance(@Param("username") String username);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.balance WHERE u.id = :id")
    User findByByIdWithBalance(@Param("id") UUID id);

    @Query(value = "SELECT * FROM users WHERE username like %:username% or name like %:username% limit 10",nativeQuery = true)
    User[] findUsersByUsername(@Param("username") String username);
}
