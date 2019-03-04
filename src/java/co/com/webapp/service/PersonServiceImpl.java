/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.service;

import co.com.webapp.domain.Person;
import co.com.webapp.eis.PersonDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author David Leonardo
 */
@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService{

    @Resource
    private SessionContext context;
    
    @EJB
    private PersonDao person_dao;
    
    @Override
    public List<Person> listPersons() {
        return person_dao.findAllPersons();
    }

    @Override
    public Person findPersonById(Person person) {
        return person_dao.findPersonById(person);
    }

    @Override
    public Person findPersonByIdNumber(Person person) {
        return person_dao.findPersonByIdNumber(person);
    }

    @Override
    public void insertPerson(Person person) {
        person_dao.insertPerson(person);
    }

    @Override
    public void modifyPerson(Person person) {
        try{
            person_dao.updatePerson(person);
        }catch(Throwable t){
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void deletePerson(Person person) {
        person_dao.deletePerson(person);
    }
}
