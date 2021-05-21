package com.xfactor.lably.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LAB_TABLE")
public class Lab {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private String address;

    private String phone;

    private String pincode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPinCode() {
        return pincode;
    }

    public void setPinCode(String pinCode) {
        this.pincode = pinCode;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    
}
