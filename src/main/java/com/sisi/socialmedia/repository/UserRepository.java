package com.sisi.socialmedia.repository;

import com.sisi.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* We will extend JpaRepository using basic CRUD operations for "User" entity
 * CRUD operation: save, update, delete, retrieve users
 * using Spring Data JPA: it will create the implementation for us during runtime*/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}