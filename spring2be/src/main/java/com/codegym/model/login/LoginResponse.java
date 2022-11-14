package com.codegym.model.login;



import java.util.List;


public class LoginResponse {

    private String jwt;

    private List<String> roles;

    private String username;

    public LoginResponse(String jwt, List<String> roles, String username) {
        this.jwt = jwt;
        this.roles = roles;
        this.username = username;
    }

    public LoginResponse(String jwt, List<String> roles) {
        this.jwt = jwt;
        this.roles = roles;
    }

    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
