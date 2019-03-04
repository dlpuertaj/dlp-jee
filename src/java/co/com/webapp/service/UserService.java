/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.service;

import co.com.webapp.domain.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David Leonardo
 */
@Local
public interface UserService {
    public List<User> listUsers();
    public User findUserById(User User);
    public User findUserByUsername(User person);
    public void insertUser(User person);
    public void modifyUser(User person);
    public void deleteUser(User person);
}
