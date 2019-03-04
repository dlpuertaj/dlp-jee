/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client.lifecycle;

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
public class PersistJpaObject {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Person p = new Person("Leonardo","Puerta Llerena","CC","73080525");
        
        tx.begin();
        
        em.persist(p);
        
        tx.commit();
        
        System.out.println("Person persisted: " + p);
        
        em.close();
    }
}
