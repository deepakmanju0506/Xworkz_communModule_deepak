package com.xworkz.Xworkz_communModule_deepak.controller;

import com.xworkz.Xworkz_communModule_deepak.costants.LocationEnum;
import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public String signup(Model model) {
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        System.out.println("signup form showing");
        model.addAttribute("list", location);
        System.out.println(location);

        return "signUp.jsp";
    }

    @PostMapping("/signup")
    public String getSignUp(XworkzDto xworkzDto, Model model) {
        System.out.println("SignUp response is displaying ");
        System.out.println("CONTROLLER" + xworkzDto);
        boolean isValid = xworkzService.validateAndSave(xworkzDto, model);
        if (isValid) {
            return "signupResponse.jsp";
        }
        model.addAttribute("dto", xworkzDto);
        return "signUp.jsp";
    }

    @GetMapping("signin")
    public String getSignin() {
        System.out.println("Signin page displaying");
        return "signIn.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String passwords, Model model) {
        System.out.println("");
        XworkzDto xworkzDto = xworkzService.onSignin(email, passwords, model);
        if (xworkzDto != null) {
            model.addAttribute("email", email);
            return "signinSuccess.jsp";
        }
        return "signIn.jsp";
    }

    @GetMapping("/update")
    public String onUpdate(@RequestParam String email, Model model) {
        System.out.println("Update page displaying");
        model.addAttribute("email", email);
        return "update.jsp";
    }

    @GetMapping("/updateUser")
    public String OnUpdateUser(@RequestParam String email, Model model){
       XworkzDto xworkzDto= xworkzService.findByEmail(email);
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        model.addAttribute("dto", xworkzDto);
        return "updateUser.jsp";
    }



}
