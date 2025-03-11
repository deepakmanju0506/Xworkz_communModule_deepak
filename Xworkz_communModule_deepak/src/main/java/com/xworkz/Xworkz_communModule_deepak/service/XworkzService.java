package com.xworkz.Xworkz_communModule_deepak.service;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import org.springframework.ui.Model;

public interface XworkzService {

    boolean validateAndSave(XworkzDto xworkzDto, Model model);

    XworkzDto onSignin(String email, String password, Model model);

    XworkzDto findByEmail(String email);

    boolean updateByEmail(XworkzDto xworkzDto,Model model);
}
