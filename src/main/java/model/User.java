package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String email;
    private String pass;
    private String name;

    public User() {}

    public User(int id, String email, String pass, String name) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.name = name;
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.pass = password;
        this.name = name;
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
