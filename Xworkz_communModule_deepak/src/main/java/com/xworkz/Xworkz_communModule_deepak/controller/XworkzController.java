package com.xworkz.Xworkz_communModule_deepak.controller;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class XworkzController {

    @Autowired
    XworkzService xworkzService;


    public XworkzController() {
        System.out.println("XworkzController is Created");
    }

    @GetMapping("/index")
    public String onHome() {
        System.out.println("home");
        return "index.jsp";
    }

    @GetMapping("/signup")
    public String signup() {
        System.out.println("signup form showing");
        return "signUp.jsp";
    }

    @PostMapping("/signup")
    public String getSignUp(XworkzDto xworkzDto, Model model) {
        System.out.println("SignUp response is displaying ");
        System.out.println("CONTROLLER"+xworkzDto);
        boolean isValid = xworkzService.validateAndSave(xworkzDto, model);
        if (isValid) {
            return "signupResponse.jsp";
        }
        model.addAttribute("dto", xworkzDto);
        return "signUp.jsp";
    }
}
