/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client;

import co.com.webapp.service.PersonServiceRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
        

/**
 *
 * @author David Leonardo
 */
public class TransactionTest {
    static Logger log = LogManager.getLogger();
    
    public static void main (String[] args) throws NamingException{
        Context jndi = new InitialContext();
        
        PersonServiceRemote personService = (PersonServiceRemote) 
                jndi.lookup("java:global/");
    }
}
