package com.xworkz.Xworkz_communModule_deepak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XworkzDto {

    private String userName;

    private Integer loginID;

    private String phoneNo;

    private String passwords;

    private String confirmPassword;

    private String location;

    private String email;

    private String gender;

    private Integer age;

    private String doB;
}
