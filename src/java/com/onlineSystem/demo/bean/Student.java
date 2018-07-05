package com.onlineSystem.demo.bean;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/1.
 */
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;      // 编号、准考证
    @Column(name = "name", length = 20)
    private String name;    // 姓名
    @Column(name = "password", length = 20)
    private String password;    // 密码
    @Column(name = "sex", length = 5)
    private String sex;         // 性别
    @Column(name = "profession", length = 40)
    private String profession;  // 专业
    @Column(name = "carNo", length = 50)
    private String cardNo;      // 身份证


    @Transient
    private String flag = "2";      // 用户类型标识符 1代表管理员 2代表学生



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
