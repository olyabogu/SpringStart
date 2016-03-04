package com.prosoft;

import org.springframework.stereotype.Component;


@Component
public class UserDao {

    private String name;
    private String lastName;

    public UserDao() {
        //for spring
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
