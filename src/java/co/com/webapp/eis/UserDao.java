/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.eis;

import co.com.webapp.domain.User;
import java.util.List;

/**
 *
 * @author David Leonardo
 */
public interface UserDao {
    public List<User> findAllUsers();
    
    public User findUserById(User person);
    
    public User findUserByUsername(User person);
    
    public void insertUser(User person);
    
    public void updateUser(User person);
    
    public void deleteUser(User person);
}
