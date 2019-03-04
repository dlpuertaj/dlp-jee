/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.service;

import co.com.webapp.domain.Person;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author David Leonardo
 */
@Remote
public interface PersonServiceRemote {
    public List<Person> listPersons();
    public Person findPersonById(Person Person);
    public Person findPersonByIdNumber(Person person);
    public void insertPerson(Person person);
    public void modifyPerson(Person person);
    public void deletePerson(Person person);
}
