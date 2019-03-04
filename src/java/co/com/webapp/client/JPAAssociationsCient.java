/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client;

import co.com.webapp.domain.Person;
import co.com.webapp.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Leonardo
 */
public class JPAAssociationsCient {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        List<Person> persons = em.createNamedQuery("Person.findAll").getResultList();
        
        em.close();
        
        for(Person p : persons){
            System.out.println("Person= " + p);
            for(User u : p.getUserList()){
                System.out.println("   User= " + u);
            }
        }
        
        
    }
}

