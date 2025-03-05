package com.xworkz.Xworkz_communModule_deepak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Signup_module_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XworkzEntity  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 @Column(name="userName")
    private String userName;
@Column(name="loginID")
    private Integer loginID;
@Column(name="phoneNo")
    private Long phoneNo;
@Column(name="passwords")
    private String password;
@Column(name="confirmPassword")
    private String confirmPassword;
@Column(name="location")
    private String location;
@Column(name="gender")
    private String gender;
@Column(name="age")
    private Integer age;
@Column(name="doB")
    private String doB;
}
