/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client.cascade;

import co.com.webapp.domain.Person;
import co.com.webapp.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Leonardo
 */
public class JPACascadePersistence {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Person p = new Person("David", "Puerta", "CC", "1047394505");
        
        User u = new User("dlpuerta ","321",p);
        
        tx.begin();
        
        em.persist(u);
        
        tx.commit();
        
        log.debug("Person=" + p);
        log.debug("User=" + u);
        em.close();
    }
    
}
