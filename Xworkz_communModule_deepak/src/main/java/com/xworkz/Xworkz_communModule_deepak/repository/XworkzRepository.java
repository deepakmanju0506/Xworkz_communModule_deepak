package com.xworkz.Xworkz_communModule_deepak.repository;

import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;

public interface XworkzRepository {
    boolean save (XworkzEntity xworkzEntity);

    XworkzEntity onSignin(String email);

    XworkzEntity findByEmail(String email);

    boolean updateByEmail(XworkzEntity xworkzEntity);






}
