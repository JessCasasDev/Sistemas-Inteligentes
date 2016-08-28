package dataSourceManagement.DAO;

import dataSourceManagement.entities.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientDAO {
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MayoristaPU");
    
    public Client persist(Client client) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(client);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return client;
    }
    
    public Client searchByUsername(String name) {
        EntityManager em = emf1.createEntityManager();
        Client client = null;        
        try {
            client = em.find(Client.class, name);
        } catch (Exception e){
        } finally {
            em.close();
        }
        return client;
    }
}
