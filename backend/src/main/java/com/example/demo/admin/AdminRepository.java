package com.example.demo.admin;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.email = ?1")
    Optional<Admin> findAdminByEmail(String email);

    @Query("SELECT a FROM Admin a WHERE a.name = ?1")
    Optional<Admin> findAdminByName(String name);

}
