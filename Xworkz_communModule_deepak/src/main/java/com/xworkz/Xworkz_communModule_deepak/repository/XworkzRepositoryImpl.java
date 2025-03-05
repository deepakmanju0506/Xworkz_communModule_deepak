package com.xworkz.Xworkz_communModule_deepak.repository;

import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonmodule");

    public XworkzRepositoryImpl (){
        System.out.println("XworkzRepository is created");
    }
    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(xworkzEntity);
        em.getTransaction().commit();
        em.close();

        return true;
    }
}
