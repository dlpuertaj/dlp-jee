/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.eis;

import co.com.webapp.domain.Person;
import java.util.List;

/**
 *
 * @author David Leonardo
 */
public interface PersonDao {
    public List<Person> findAllPersons();
    
    public Person findPersonById(Person person);
    
    public Person findPersonByIdNumber(Person person);
    
    public void insertPerson(Person person);
    
    public void updatePerson(Person person);
    
    public void deletePerson(Person person);
}
