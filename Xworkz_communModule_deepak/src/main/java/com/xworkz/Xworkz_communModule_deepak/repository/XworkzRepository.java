package com.xworkz.Xworkz_communModule_deepak.repository;

import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;

public interface XworkzRepository {
    boolean save(XworkzEntity xworkzEntity);

    XworkzEntity onSignin(String email);

    long userNameExist(String userName);

    long userEmailExist(String email);

    long userPhoneNoExist(String phoneNo);

    XworkzEntity findByEmail(String email);

    boolean updateByEmail(XworkzEntity xworkzEntity);

    boolean updateCount(XworkzEntity xworkzEntity);

    boolean setLockTime(String email, XworkzEntity xworkzEntity);

    boolean forgetPasswordUpdate(XworkzEntity xworkzEntity);

    XworkzEntity getDataForUpdate(String email);

    void deleteUserByEmail(String email);
}
