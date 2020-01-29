package com.shiva.a5exposetrancientgson;

import com.google.gson.annotations.Expose;

public class Person {
    /*
        String name;
        int age;
        String email;
        // Here the word transient will hide the password from creating json
        private transient String  password;
    */
    @Expose
    private String name;
    @Expose(serialize = false, deserialize = false)
    private int age;
    private String email;
    private String password;

    Person(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
