package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_users")
public class User extends BaseEntity {


    private String login;
    private String password;
    private String nick;
    private String email;
    private String phone;
    private String from;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
