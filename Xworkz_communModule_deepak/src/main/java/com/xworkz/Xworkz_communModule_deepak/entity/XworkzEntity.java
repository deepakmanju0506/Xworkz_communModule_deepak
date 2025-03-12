package com.xworkz.Xworkz_communModule_deepak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="module_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name ="getEmailAndPassword" ,query = "Select a from XworkzEntity a where a.email=:email")
@NamedQuery(name = "getByEmail",  query = "select a From XworkzEntity a where a.email = :email")
@NamedQuery(name="setByEmail", query="Update XworkzEntity a set a.userName = :userName, a.age = :age, a.doB = :doB, a.phoneNo = :phoneNo, a.location = :location, a.passwords = :passwords Where a.email = :email")
@NamedQuery(name = "passwordUpdate", query = "Update XworkzEntity a set a.passwords = :passwords, a.signInCount = 0 where a.email = :email")
@NamedQuery(name = "getUpdate", query = "select a from XworkzEntity a where a.email= :email")
@NamedQuery(name="userNameCount", query = "select count(a) from XworkzEntity a where a.userName=: userName")
@NamedQuery(name="userEmailCount", query = "select count(a) from XworkzEntity a where a.email=: email")
@NamedQuery(name="userPhoneNo",query = "select count(a) from XworkzEntity a where a.phoneNo=: phone")
@NamedQuery(name = "deleteUser", query = "Delete from XworkzEntity Where email=:email")
public class XworkzEntity  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 @Column(name="userName")
    private String userName;
@Column(name="loginID")
    private Integer loginID;
@Column(name="phoneNo")
    private String phoneNo;
@Column(name="passwords")
    private String passwords;
@Column(name="location")
    private String location;
@Column(name = "email")
private String email;
@Column(name="gender")
    private String gender;
@Column(name="age")
    private Integer age;
@Column(name="doB")
    private String doB;
@Column(name = "signInCount")
    private Integer signInCount= -1;
@Column(name = "lockTime")
private LocalDateTime lockTime;
}
