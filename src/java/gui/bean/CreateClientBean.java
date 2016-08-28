package gui.bean;

import businessLogic.controller.HandleClient;
import dataSourceManagement.entities.Authentication;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CreateClientBean implements Serializable{
    private String username;
    private String password;

    private String name;
    private String nit;
    private String message;
   @ManagedProperty(value="#{userBean}")
   private CreateUserBean userBean;

    public CreateUserBean getUserBean() {
        return userBean;
    }
   
   public void setUserBean(CreateUserBean ub){
       this.userBean = ub;
   }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    private String address;
    
    public void ClientProfileBean(){}
    
    public String getName(){
        return this.name;
    }
    
    public String getNit(){
        return this.nit;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNit(String nit){
        this.nit = nit;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void createClient(){
        Authentication userCreated = userBean.createUser(username, password, "2");
        System.out.println("HE LLEGADO A CREATE CLIENT");
        if (userCreated != null){
            HandleClient hc = new HandleClient();
            boolean bl = hc.createClient(name, nit, address, userCreated);     
            if (bl)   
               message = "Usuario creado con éxito";
            else
                message = "El Cliente no se pudo crear";
        }
        else
            message = "No se pudo crear el usuario";
    }
}

