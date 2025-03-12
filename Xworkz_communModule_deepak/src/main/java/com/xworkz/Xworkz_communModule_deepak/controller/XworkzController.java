package com.xworkz.Xworkz_communModule_deepak.controller;

import com.xworkz.Xworkz_communModule_deepak.costants.LocationEnum;
import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import com.xworkz.Xworkz_communModule_deepak.service.XworkzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
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
    public String getSignUp(@ModelAttribute("dto") XworkzDto xworkzDto, Model model) {
        System.out.println("SignUp response is displaying ");
        System.out.println("CONTROLLER" + xworkzDto);

        boolean userNameExists = xworkzService.userNameExist(xworkzDto.getUserName());

        if (userNameExists) {
            model.addAttribute("errorMessage", "User Name is Already Exist");
            return "signUp.jsp";
        }

        boolean userEmailExist = xworkzService.userEmailExist(xworkzDto.getEmail());
        if (userEmailExist) {
            model.addAttribute("errorMessage", "User Email is Already Exist");
            return "signUp.jsp";
        }
//        long userPhoneNoExist = xworkzService.userPhoneNoExist(xworkzDto.getPhoneNo());
//        if(userPhoneNoExist){
//            model.addAttribute("errorMessage","User Phone is Already Exist");
//            return "signUp.jsp";
//        }



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
        XworkzEntity xworkzEntity = xworkzService.onSignin(email, passwords, model);
        if (xworkzEntity == null) {
            model.addAttribute("Error", "Incorrect email or password");
            return "signIn.jsp";
        }
        if (xworkzEntity.getSignInCount() >= 3) {
            return "signIn.jsp";
        }
        if (xworkzEntity.getSignInCount() == 0) {
            return "signinSuccess.jsp";
        }
        if (xworkzEntity.getSignInCount() == -1) {
            return "setPassword.jsp";
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
    public String OnUpdateUser(@RequestParam String email, Model model) {
        XworkzDto xworkzDto = xworkzService.findByEmail(email);
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        model.addAttribute("dto", xworkzDto);
        return "updateUser.jsp";
    }

    @PostMapping("/updateUser")
    public String updateUser(XworkzDto xworkzDto, Model model) {
        boolean ref = xworkzService.updateByEmail(xworkzDto, model);
        System.out.println("CONTROLLER UPDATE :" + ref);
        model.addAttribute("email", xworkzDto.getEmail());
        return "updateSuccess.jsp";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String email, @RequestParam String passwords, @RequestParam String confirmPassword) {
        System.out.println("Displaying Update Password page from controller");
        if (xworkzService.forgetPasswordUpdate(email, passwords, confirmPassword)) {
            return "signIn.jsp";
        }
        return "setPassword.jsp";
    }

    @GetMapping("/deleteData")
    public String deleteUser(@RequestParam("email") String email){
        xworkzService.deleteUserByEmail(email);
        log.info(email+"Account is deleted");
        return "DeleteUser.jsp";
    }

}
