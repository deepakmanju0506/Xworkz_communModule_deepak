package com.xworkz.Xworkz_communModule_deepak.repository;

import com.xworkz.Xworkz_communModule_deepak.dto.XworkzDto;
import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.*;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonmodule");

    public XworkzRepositoryImpl (){
        System.out.println("XworkzRepository is created");
    }
    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        System.out.println("REPOSITORY:"+xworkzEntity);
        em.getTransaction().begin();
        em.persist(xworkzEntity);
        em.getTransaction().commit();
        em.close();


        return true;
    }

    @Override
    public XworkzEntity onSignin(String email) {
        EntityManager eManag = emf.createEntityManager();
        Query query = eManag.createNamedQuery("getEmailAndPassword").setParameter("email", email);
        try {
            XworkzEntity xworkzEntity = (XworkzEntity) query.getSingleResult();
            System.out.println("REPOSITORY :" + xworkzEntity);
            return xworkzEntity;
        } catch (NoResultException e) {
            System.out.println("No entity found for the given email and password.");
            return null;
        }
    }

    @Override
    public XworkzEntity findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("getByEmail").setParameter("email",email);
        query.getSingleResult();
        System.out.println();

        return (XworkzEntity) query.getSingleResult();
    }

    @Override
    public boolean updateByEmail(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            Query query = em.createNamedQuery("setByEmail");

            query.setParameter("userName",xworkzEntity.getUserName());
            query.setParameter("age",xworkzEntity.getAge());
            query.setParameter("dob",xworkzEntity.getDoB());
            query.setParameter("phoneNo",xworkzEntity.getPhoneNo());
            query.setParameter("location",xworkzEntity.getLocation());
            query.setParameter("password",xworkzEntity.getPasswords());
            query.setParameter("email",xworkzEntity.getEmail());

            int updateCount = query.executeUpdate();
            et.commit();
            return updateCount > 0 ;
        }catch (Exception e){
            e.getMessage();
            if(et.isActive()){
                et.rollback();
            }
            return false;
        }finally{
            em.close();
        }

    }

}
