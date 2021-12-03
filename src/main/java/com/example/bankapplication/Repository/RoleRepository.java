package com.example.bankapplication.Repository;


import com.example.bankapplication.main.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM Customer u WHERE u.firstName = ?1")
    Role findByName(String name);

}
