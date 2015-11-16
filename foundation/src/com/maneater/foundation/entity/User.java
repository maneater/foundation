package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_user")
public class User extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private String nick;
    private String email;
    private String phone;
    private String source;
    private String headPicUrl = "http://chuantupian.com/8/uploads/2015/11/180824_8.jpg";

    /**
     * *
     */

    public String getLogin() {
        return login;
    }

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nick='" + nick + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'' +
                ", headPicUrl='" + headPicUrl + '\'' +
                "} " + super.toString();
    }
}
