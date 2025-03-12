package com.xworkz.Xworkz_communModule_deepak.repository;

import com.xworkz.Xworkz_communModule_deepak.entity.XworkzEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonmodule");

    public XworkzRepositoryImpl() {
        System.out.println("XworkzRepository is created");
    }

    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        System.out.println("REPOSITORY:" + xworkzEntity);
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
    //userName is exist method
    @Override
    public long userNameExist(String userName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Query query = em.createNamedQuery("userNameCount");
            query.setParameter("userName", userName);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return 0;
        } finally {
            em.close();
        }

    }



    @Override
    public long userPhoneNoExist(String phoneNo) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Query query = em.createNamedQuery("userPhoneNoCount");
            query.setParameter("phoneNo", phoneNo);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return 0;
        } finally {
            em.close();
        }
    }



    @Override
    public XworkzEntity findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("getByEmail").setParameter("email", email);
        query.getSingleResult();
        System.out.println();

        return (XworkzEntity) query.getSingleResult();
    }

    @Override
    public boolean updateByEmail(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Query query = em.createNamedQuery("setByEmail");

            query.setParameter("userName", xworkzEntity.getUserName());
            query.setParameter("age", xworkzEntity.getAge());
            query.setParameter("doB", xworkzEntity.getDoB());
            query.setParameter("phoneNo", xworkzEntity.getPhoneNo());
            query.setParameter("location", xworkzEntity.getLocation());
            query.setParameter("passwords", xworkzEntity.getPasswords());
            query.setParameter("email", xworkzEntity.getEmail());

            int updateCount = query.executeUpdate();
            et.commit();
            System.out.println("REPOSITORY :" + updateCount);
            return updateCount > 0;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        } finally {
            em.close();
        }

    }

    @Override
    public boolean updateCount(XworkzEntity xworkzEntity) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        try {
            eTrans.begin();
            eManag.merge(xworkzEntity);
            eTrans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            eManag.close();
        }
    }

    @Override
    public boolean setLockTime(String email, XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(xworkzEntity);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }

    }

    @Override
    public boolean forgetPasswordUpdate(XworkzEntity xworkzEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Query query = em.createNamedQuery("passwordUpdate");
            query.setParameter("passwords", xworkzEntity.getPasswords());
            query.setParameter("email", xworkzEntity.getEmail());

            int updateRow = query.executeUpdate();
            et.commit();
            return updateRow > 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        } finally {
            em.close();
        }

    }

    @Override
    public XworkzEntity getDataForUpdate(String email) {

        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        try {
            Query query = eManag.createNamedQuery("getUpdate");
            query.setParameter("email", email);
            return (XworkzEntity) query.getSingleResult();
        } catch (Exception e) {
            if (eTrans.isActive()) {
                eTrans.rollback();
                e.printStackTrace();
            }
            return null;
        } finally {
            eManag.close();
        }
    }

    @Override
    public void deleteUserByEmail(String email) {
       EntityManager em = emf.createEntityManager();
       EntityTransaction et = em.getTransaction();
       et.begin();
       em.createNamedQuery("deleteUser").setParameter("email",email).executeUpdate();
       et.commit();
    }

    @Override
    public long userEmailExist(String email) {
        return 0;
    }

}
