package com.xworkz.Xworkz_communModule_deepak.service;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

public interface XworkzService {

    boolean validateAndSave(XworkzDto xworkzDto, Model model);

    XworkzEntity onSignin(String email, String password, Model model);

    boolean userNameExist(String userName);

    boolean userEmailExist(String email);

    long userPhoneNoExist(String phoneNo);

    XworkzDto findByEmail(String email);

    boolean forgetPasswordUpdate(String email, String passwords, String confirmPassword);

    boolean updateByEmail(XworkzDto xworkzDto, Model model);

   boolean accountLock(LocalDateTime locktime);

    void deleteUserByEmail(String email);
}
