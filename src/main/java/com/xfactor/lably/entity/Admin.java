package com.xfactor.lably.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //set Admin class as an entity in db
@Table(name = "TBL_ADMIN") //If removed, table with default name will be created i.e. ADMIN in this case
public class Admin {

    @Id //sets id as the primary key of the table
    @GeneratedValue //auto-generates unique id values
    @Column(name = "id")
    private Long Id;

    @Column(name = "name") //If removed, column will be set as default i.e. NAME in this case
    private String name;

    private String username;

    private String password;

    @Column(name = "dept") //changes column name from default to DEPT
    private String department;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    
    
}