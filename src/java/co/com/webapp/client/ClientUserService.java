/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client;

import co.com.webapp.domain.User;
import co.com.webapp.service.UserServiceRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author David Leonardo
 */
public class ClientUserService {
    public static void main(String[] args){
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        
        try {
            Context jndi = new InitialContext();
            UserServiceRemote personService = (UserServiceRemote) jndi.lookup("java:global/MoviesAndFood/UserServiceImpl!co.com.webapp.service.UserServiceRemote");
            List<User> persons = personService.listUsers();
        
            for(User p : persons){
                System.out.println(p);
            }
            
            System.out.println("\nFin de la llamada al EJB desde cliente");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
