package com.example.demo_crud.Model;

public class User {
    private  String email;
    private  String password;
    private int id;
    private String name;

    public User(String email, String password, String name) {

        this.email = email;
        this.password = password;
        this.name = name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
