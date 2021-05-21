package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    Admin findByUsername(String username);
    
    Admin findByUsernameAndPasswordAndName(String username, String password, String name);

    @Query("SELECT admin FROM Admin admin WHERE admin.department = :department")
    List<Admin> retrieveByDepartment(String department);
}
