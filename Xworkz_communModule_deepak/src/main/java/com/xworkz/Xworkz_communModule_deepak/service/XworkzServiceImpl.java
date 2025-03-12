package com.xworkz.Xworkz_communModule_deepak.service;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import com.xworkz.Xworkz_communModule_deepak.repository.XworkzRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    XworkzRepository xworkzRepository;

    private BCryptPasswordEncoder encodedPassword = new BCryptPasswordEncoder();

    XworkzEntity xworkzEntity = new XworkzEntity();

    String autoPassword;

    public String passwordGenerate() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String values = upper + lower + numbers;

        Random rndm = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 6; i++) {

            password.append(values.charAt(rndm.nextInt(values.length())));

        }
        return password.toString();
    }


    @Override
    public boolean validateAndSave(XworkzDto xworkzDto, Model model) {
        System.out.println(xworkzDto);
        boolean isValid = true;

        if (xworkzDto != null) {


            if (xworkzDto.getUserName() != null && !xworkzDto.getUserName().isEmpty() &&
                    xworkzDto.getUserName().length() >= 3 && xworkzDto.getUserName().length() <= 50) {
                System.out.println("user name valid");
            } else {
                isValid = false;
                model.addAttribute("userNameError", "name must be between 3 and 25 characters and start with an uppercase letter");
                System.out.println("user name Invalid");

            }
            String phoneNo = xworkzDto.getPhoneNo() != null ? xworkzDto.getPhoneNo().toString() : "";
            if (xworkzDto.getPhoneNo() != null && phoneNo.length() == 10 && phoneNo.matches("^[976]\\d{9}$")) {
                System.out.println("phoneNo valid");

            } else {
                isValid = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9,7,6 with this no only");
                System.out.println("phoneNo Invalid");

            }
            if (xworkzDto.getEmail() != null && xworkzDto.getEmail().contains("@gmail.com") && xworkzDto.getEmail().matches("^[a-z0-9]+@gmail\\.com$")) {
                System.out.println("email valid");


            } else {
                isValid = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
                System.out.println("email Invalid");

            }

            if (xworkzDto.getAge() != null && xworkzDto.getAge() >= 18) {
                System.out.println("age valid");
            } else {
                isValid = false;
                System.out.println("age Invalid");

                model.addAttribute("ageError", "Age must be above 18+");
            }
            if (xworkzDto.getGender() != null) {
                System.out.println("age valid");
            } else {
                isValid = false;
                model.addAttribute("age can't be null");
            }

        }
        System.out.println(isValid);
        if (isValid) {
            autoPassword = passwordGenerate();
            xworkzEntity.setPasswords(autoPassword);

            XworkzEntity xworkzEntity1 = new XworkzEntity();
            xworkzEntity1.setUserName(xworkzDto.getUserName());
            xworkzEntity1.setEmail(xworkzDto.getEmail());
            xworkzEntity1.setPhoneNo(xworkzDto.getPhoneNo());
            xworkzEntity1.setPasswords(autoPassword);
            System.out.println("Auto_Password :" + autoPassword);
            xworkzEntity1.setGender(xworkzDto.getGender());
            xworkzEntity1.setDoB(xworkzDto.getDoB());
            xworkzEntity1.setLocation(xworkzDto.getLocation());
            xworkzEntity1.setAge(xworkzDto.getAge());
            xworkzEntity1.setLoginID(xworkzDto.getLoginID());
            xworkzRepository.save(xworkzEntity1);
            System.out.println("SERVICE:" + xworkzDto);
            return isValid;
        }


        return isValid;
    }

    @Override
    public XworkzEntity onSignin(String email, String passwords, Model model) {
        XworkzDto xworkzDto = new XworkzDto();
        XworkzEntity xworkzEntity = xworkzRepository.onSignin(email);
        if (xworkzEntity == null) {
            return null;
        }
        if (xworkzEntity.getLockTime() != null && accountLock(xworkzEntity.getLockTime())) {
            xworkzEntity.setLockTime(null);
            xworkzEntity.setSignInCount(0);
            xworkzRepository.updateCount(xworkzEntity);
        }
        if (xworkzEntity.getSignInCount() == -1) {
            return xworkzEntity;
        } else if (xworkzEntity.getSignInCount() >= 3) {
            model.addAttribute("errorMessage", "Account Lock");
            xworkzEntity.setLockTime(LocalDateTime.now());
            xworkzRepository.setLockTime(email, xworkzEntity);
            return null;
        } else if (encodedPassword.matches(passwords, xworkzEntity.getPasswords())) {
            xworkzEntity.setSignInCount(0);
            xworkzRepository.updateCount(xworkzEntity);
            xworkzRepository.setLockTime(email, xworkzEntity);
            return xworkzEntity;
        } else {
            int count = xworkzEntity.getSignInCount() + 1;
            xworkzEntity.setSignInCount(count);
            xworkzEntity.setLockTime(LocalDateTime.now());
            xworkzRepository.updateCount(xworkzEntity);
            xworkzRepository.setLockTime(email, xworkzEntity);
            return null;
        }
    }
    // userName exist method
    @Override
    public boolean userNameExist(String userName) {
        return xworkzRepository.userNameExist(userName) > 0;
    }
//    User email exist method
    @Override
    public boolean userEmailExist(String email) {
        return xworkzRepository.userEmailExist(email) > 0;
    }

    @Override
    public long userPhoneNoExist(String phoneNo) {
        return xworkzRepository.userPhoneNoExist(phoneNo);
    }

    @Override
    public XworkzDto findByEmail(String email) {
        XworkzDto xworkzDto = new XworkzDto();
        XworkzEntity xworkzEntity1 = xworkzRepository.findByEmail(email);

        BeanUtils.copyProperties(xworkzEntity1, xworkzDto);
        System.out.println("Get-Service :" + xworkzEntity1);

        return xworkzDto;
    }


    @Override
    public boolean updateByEmail(XworkzDto xworkzDto, Model model) {

        boolean isValidate = true;

        if (xworkzDto != null) {

            BeanUtils.copyProperties(xworkzDto, xworkzEntity);

            if (xworkzDto.getUserName() != null && !xworkzDto.getUserName().isEmpty() &&
                    xworkzDto.getUserName().length() >= 3 && xworkzDto.getUserName().length() <= 25 &&
                    xworkzDto.getUserName().matches("[A-Z][a-z]*")) {
                xworkzEntity.setUserName(xworkzDto.getUserName());
            } else {
                isValidate = false;
                model.addAttribute("userNameError", "Username must be between 3 and 25 characters and start with an uppercase letter");
            }

            String strPhone = xworkzDto.getPhoneNo() != null ? xworkzDto.getPhoneNo().toString() : "";
            if (xworkzDto.getPhoneNo() != null && strPhone.length() == 10 && strPhone.matches("^[976]\\d{9}$")) {
                xworkzEntity.setPhoneNo(xworkzDto.getPhoneNo());
            } else {
                isValidate = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9, 7, or 6");
            }

            if (xworkzDto.getEmail() != null && xworkzDto.getEmail().contains("@gmail.com") && xworkzDto.getEmail().matches("^[a-z0-9]+@gmail\\.com$")) {
                xworkzEntity.setEmail(xworkzDto.getEmail());
            } else {
                isValidate = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
            }

            if (xworkzDto.getAge() != null && xworkzDto.getAge() >= 18) {
                xworkzEntity.setAge(xworkzDto.getAge());
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Age must be above 18+");
            }

            if (xworkzDto.getPasswords().equals(xworkzDto.getConfirmPassword()) && xworkzDto.getPasswords().length() >= 8 && xworkzDto.getPasswords().matches(".*[0-9].*") && xworkzDto.getPasswords().matches(".*[!@#$%^&,.].*") && xworkzDto.getPasswords().matches(".*[A-Z].*")) {
                String encoded = encodedPassword.encode(xworkzDto.getPasswords());
                xworkzEntity.setPasswords(encoded);

            } else {
                isValidate = false;
                model.addAttribute("passwordError", "Password must be at least 8 characters and must be contain Special character and Numbers");
            }

            xworkzRepository.updateByEmail(xworkzEntity);
            System.out.println("SERVICE UPDATE :" + xworkzDto);
        }
        return isValidate;

    }

    @Override
    public boolean forgetPasswordUpdate(String email, String passwords, String confirmPassword) {
        if (passwords.equals(confirmPassword)) {
            XworkzEntity xworkzEntity = xworkzRepository.getDataForUpdate(email);
            if (xworkzEntity != null) {
                xworkzEntity.setPasswords(encodedPassword.encode(confirmPassword));
                xworkzEntity.setSignInCount(0);
                return xworkzRepository.forgetPasswordUpdate(xworkzEntity);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean accountLock(LocalDateTime locktime) {

        return locktime.plusMinutes(1).isBefore(LocalDateTime.now());

    }

    @Override
    public void deleteUserByEmail(String email) {
        xworkzRepository.deleteUserByEmail(email);
    }
}
