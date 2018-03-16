package com.demo.webapp.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import java.security.MessageDigest;
import java.util.List;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import com.demo.webapp.domain.entities.User;

public class AuthenticationService {
    private EntityManagerFactory emf;

    public AuthenticationService(EntityManagerFactory emf) 
        throws NoSuchAlgorithmException {
        this.emf = emf;
        ensureUser("admin", "admin");
    }

    public boolean authenticate(String username, String password) 
        throws NoSuchAlgorithmException {

        User user = null;
        EntityManager em = emf.createEntityManager();
        try {
            user = em.createQuery("select u from User u where username='" + username + 
                            "' and hashedPwd='" + getHashedPassword(password) + "'", User.class)
                            .getSingleResult();
        }
        catch(Exception ignored) {
        }
        finally {
            if(em != null) {
                em.close();
            }
        }
        return user != null;
    }

    // Makes sure there is one user in db
    public void ensureUser(String username, String password) 
        throws NoSuchAlgorithmException {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("select u from User u", User.class).getResultList();

        if(users.size() == 0) {
            User user = new User();
            user.setUsername(username);
            user.setHashedPwd(getHashedPassword(password));

            
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        em.close();
    }

    private static String getHashedPassword(String password)
        throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, digest.digest()).toString(16);
    }
}