/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.eis;

import co.com.webapp.domain.User;
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
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName = "PersonPU")
    EntityManager em;
    
    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User findUserById(User person) {
        return em.find(User.class, person.getUserId());
    }

    @Override
    public User findUserByUsername(User person) {
        Query query = em.createQuery("from User p where p.idNumber =: idNumber");
        query.setParameter("idNumber", person.getUsername());
        
        return (User) query.getSingleResult();
    }

    @Override
    public void insertUser(User person) {
        em.persist(person);
    }

    @Override
    public void updateUser(User person) {
        em.merge(person);
    }

    @Override
    public void deleteUser(User person) {
        em.merge(person);
        em.remove(person);
    }
    
}
