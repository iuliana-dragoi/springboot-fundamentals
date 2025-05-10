package com.crode.springboot_fundamentals.repository;


import com.crode.springboot_fundamentals.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
