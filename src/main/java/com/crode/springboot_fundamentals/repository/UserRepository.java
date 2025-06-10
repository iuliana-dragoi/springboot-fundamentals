package com.crode.springboot_fundamentals.repository;


import com.crode.springboot_fundamentals.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u From User u JOIN u.roles r where r.name = :roleName")
    List<User> findUsersByRoleName(@Param("roleName") String roleName);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeLessThan(int age);
}
