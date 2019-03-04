/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.webapp.web;

import co.com.webapp.domain.Person;
import co.com.webapp.service.PersonService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David Leonardo
 */
@WebServlet("/ListPersons")
public class ControllerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PersonService personService;
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws  ServletException, IOException{
        
        List<Person> persons = personService.listPersons();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("listPersons.jsp").forward(request, response);
    }
}
