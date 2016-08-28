package dataSourceManagement.DAO;

import dataSourceManagement.entities.Authentication;
import dataSourceManagement.entities.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RoleDAO {
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MayoristaPU");
    public Role searchById(int id) {
        EntityManager em = emf1.createEntityManager();
        Role role = null;        
        try {
            role = em.find(Role.class, id);
        } catch (Exception e){
        } finally {
            em.close();
        }
        return role;
    }
}
