/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.service;

import co.com.webapp.domain.User;
import co.com.webapp.eis.UserDao;
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
public class UserServiceImpl implements UserServiceRemote, UserService{

    @Resource
    private SessionContext context;
    
    @EJB
    private UserDao person_dao;
    
    @Override
    public List<User> listUsers() {
        return person_dao.findAllUsers();
    }

    @Override
    public User findUserById(User person) {
        return person_dao.findUserById(person);
    }

    @Override
    public User findUserByUsername(User person) {
        return person_dao.findUserByUsername(person);
    }

    @Override
    public void insertUser(User person) {
        person_dao.insertUser(person);
    }

    @Override
    public void modifyUser(User person) {
        try{
            person_dao.updateUser(person);
        }catch(Throwable t){
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void deleteUser(User person) {
        person_dao.deleteUser(person);
    }
}
