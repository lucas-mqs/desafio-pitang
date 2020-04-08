package com.pitang.lucasmarques.dto;

public class LoginDTO {
    
    private String login;
    private String password;
    
    public LoginDTO() {
        super();
    }

    public LoginDTO(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
