/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author David Leonardo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PersonOne.findAll", query = "SELECT p FROM PersonOne p ORDER BY p.personId")})
@Table(name = "person_one")
public class PersonOne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;
    
    @Column(name = "first_name",nullable = false, length = 45 )
    private String firstName;
    
    @Column(name = "last_name",nullable = false, length = 45 )
    private String lastName;
    
    @Column(name = "id_type",nullable = false, length = 2 )
    private String idType;
    
    @Column(name = "id_number",nullable = false, length = 45 )
    private String idNumber;

    public PersonOne() {
    }

    public PersonOne(Integer personId,String firstName, String lastName, String idType, String idNumber) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idType = idType;
        this.idNumber = idNumber;
    }
    
    public PersonOne(String firstName, String lastName, String idType, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idType = idType;
        this.idNumber = idNumber;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}
