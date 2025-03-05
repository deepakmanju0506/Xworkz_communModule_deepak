package com.xworkz.Xworkz_communModule_deepak.service;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import org.springframework.ui.Model;

public interface XworkzService {

    boolean validateAndSave(XworkzDto xworkzDto, Model model);
}
