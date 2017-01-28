package com.seven.eleven.Model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 * Created by JPMPC-B210 on 1/6/2017.
 */
@Entity
public class SevenElevenModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "email must not be empty" )
    @Email(message = "Invalid email")
    //@Pattern(regexp="[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}", message = "email is invalid")
    private String email;

    @NotBlank(message = "Mobile number must not be empty" )
    @Pattern(regexp="(^$|[0-9]{11})", message = "Mobile number is invalid")
    private String tel_no;

    private String DOBMonth;
    private String DOBDay;
    private String DOBYear;

    @NotEmpty(message = "Mobile number must not be empty")
    private String gender;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getTel_no() {
        return tel_no;
    }
    public int getId() {
        return id;
    }
    public String getDOBMonth() {
        return DOBMonth;
    }
    public String getDOBDay() {
        return DOBDay;
    }
    public String getDOBYear() {
        return DOBYear;
    }
    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDOBMonth(String DOBMonth) {
        this.DOBMonth = DOBMonth;
    }
    public void setDOBDay(String DOBDay) {
        this.DOBDay = DOBDay;
    }
    public void setDOBYear(String DOBYear) {
        this.DOBYear = DOBYear;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}