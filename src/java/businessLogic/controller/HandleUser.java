package businessLogic.controller;

import dataSourceManagement.DAO.AuthenticationDAO;
import dataSourceManagement.DAO.RoleDAO;
import dataSourceManagement.entities.Authentication;
import dataSourceManagement.entities.Role;
import javax.annotation.Resource;
import javax.ejb.EJBContext;

public class HandleUser {
    public Authentication createUser(String user_name, String password, int role){
        RoleDAO role_dao = new RoleDAO();
        Authentication auth = new Authentication();
        auth.setUserName(user_name);
        auth.setPassword(password);
        Role r = role_dao.searchById(role);
        auth.setRoleId(r);
        AuthenticationDAO authDao = new AuthenticationDAO();
        Authentication auth_1 = authDao.persist(auth);
        
        return auth_1;
    }
}
