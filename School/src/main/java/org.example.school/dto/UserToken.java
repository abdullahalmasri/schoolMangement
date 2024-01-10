package org.example.school.dto;

public class UserToken {

    private String token;
    private String username;

    public UserToken(){

    }

    public UserToken(String token, String username){
        this.token = token;
        this.username = username;
    }

    public UserToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

