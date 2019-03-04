/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.client;

import co.com.webapp.domain.Person;
import co.com.webapp.domain.User;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Leonardo
 */
public class JpqlTest {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        String jpql = null;
        Query q = null;
        List<Person> persons = null;
        Person person = null;
        Iterator iter = null;
        Object[] tuple = null;
        List<String> nombres = null;
        List<User> users = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        log.debug("\n1 Select all persons");
        jpql = "select p from Person p";
        persons = em.createQuery(jpql).getResultList();
        showPersons(persons);
        
        log.debug("\n2 Select person with id ");
        jpql = "select p from Person p where p.personId = 2";
        person = (Person) em.createQuery(jpql).getSingleResult();
        log.debug(person.toString());
        
        log.debug("\n3 select person by name ");
        jpql = "select p from Person p where p.firstName = 'David'";
        person = (Person) em.createQuery(jpql).getSingleResult();
        log.debug(person.toString());
        
        log.debug("\n4 Select individual data ");
        jpql = "select p.firstName as Name, p.lastName as LastName from Person p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tuple = (Object[]) iter.next();
            String name = (String)tuple[0];
            String lastName = (String)tuple[1];
            log.debug(name + " - " + lastName);
        }
        
    }

    private static void showPersons(List<Person> persons) {
        for(Person p : persons){
            log.debug(p.toString());
        }    
    }
}
