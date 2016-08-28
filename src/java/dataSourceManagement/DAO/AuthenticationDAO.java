package dataSourceManagement.DAO;

import dataSourceManagement.entities.Authentication;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthenticationDAO {
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MayoristaPU");
    
    public Authentication persist(Authentication authentication) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(authentication);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return authentication;
    }
    
    public Authentication searchByUsername(String userName) {
        EntityManager em = emf1.createEntityManager();
        Authentication auth = null;        
        try {
            auth = em.find(Authentication.class, userName);
        } catch (Exception e){
        } finally {
            em.close();
        }
        return auth;
    }
    
}
