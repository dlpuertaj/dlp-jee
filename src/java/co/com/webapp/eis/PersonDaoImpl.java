/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.eis;

import co.com.webapp.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author David Leonardo
 */
@Stateless
public class PersonDaoImpl implements PersonDao{

    @PersistenceContext(unitName = "PersonPU")
    EntityManager em;
    
    @Override
    public List<Person> findAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person findPersonById(Person person) {
        return em.find(Person.class, person.getPersonId());
    }

    @Override
    public Person findPersonByIdNumber(Person person) {
        Query query = em.createQuery("from Person p where p.idNumber =: idNumber");
        query.setParameter("idNumber", person.getIdNumber());
        
        return (Person) query.getSingleResult();
    }

    @Override
    public void insertPerson(Person person) {
        em.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.merge(person);
        em.remove(person);
    }
    
}
