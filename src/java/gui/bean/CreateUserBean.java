package gui.bean;

import businessLogic.controller.HandleUser;
import dataSourceManagement.entities.Authentication;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="userBean")
@ViewScoped
public class CreateUserBean implements Serializable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
    
    public Authentication createUser(String username, String password, String role){        
        System.out.println("HE LLEGADO A CREATE USER");
        HandleUser hu = new HandleUser();        
        return hu.createUser(username, password, Integer.parseInt(role));
    }
}