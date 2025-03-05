package com.xworkz.Xworkz_communModule_deepak.service;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import com.xworkz.Xworkz_communModule_deepak.repository.XworkzRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    XworkzRepository xworkzRepository;

    XworkzEntity xworkzEntity = new XworkzEntity();


    @Override
    public boolean validateAndSave(XworkzDto xworkzDto, Model model) {

        boolean isValid = true;

        if(xworkzDto != null){
            BeanUtils.copyProperties(xworkzDto,xworkzEntity);

            if(xworkzDto.getUserName() != null && !xworkzDto.getUserName().isEmpty() &&
                    xworkzDto.getUserName().length()>=3 && xworkzDto.getUserName().length()<= 50 &&
            xworkzDto.getUserName().matches("[A-Z][a-z]*")){
                xworkzEntity.setUserName(xworkzDto.getUserName());
            }else{
                isValid = false;
                model.addAttribute("Name Error","name must be between 3 and 25 characters and start with an uppercase letter");
            }
            String phoneNo = xworkzDto.getPhoneNo() != null ? xworkzDto.getPhoneNo().toString() :"";
            if(xworkzDto.getPhoneNo() != null && phoneNo.length() == 10 && phoneNo.matches("^[976]\\d{9}$")) {
                xworkzEntity.setPhoneNo(xworkzDto.getPhoneNo());
            }else{
                isValid = false;
                model.addAttribute("phoneNo Error","Phone number must be exactly 10 digits and start with 9,7,6 with this no only");
            }
            if(isValid){
                return xworkzRepository.save(xworkzEntity);
            }

        }

        return false;
    }
}
