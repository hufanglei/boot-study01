package com.hfl.model;


import javax.persistence.*;


/**
 * Created by hfl on 2017-4-27.
 *
 * 1、 在主建Id上需要加注释：@Id和@GeneratedValue(strategy = GenerationType.AUTO)才会自动增长

 2、 在需要重新设置表字段名的属性上加注释@Column(name = "字段名")即可。

 3、 在类名上添加注释：@Entity和@Table(name = "t_user")，t_user是表名
 */

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "nick_name")
    private String nickName;

    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
