/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client.lifecycle;

import static co.com.webapp.client.lifecycle.FindJpaObject.log;
import co.com.webapp.domain.Person;
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
public class DeleteJpaObject {
     static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        Person p = em.find(Person.class, 1);
        
        tx.commit();
        
        log.debug("Object found... " + p );

        EntityTransaction tx2 = em.getTransaction();
        
        tx2.begin();
        
        em.remove(p);
        
        tx2.commit();
        
        log.debug("Object removed... " + p );
    }
}
