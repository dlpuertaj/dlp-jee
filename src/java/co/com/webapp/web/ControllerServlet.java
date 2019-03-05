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
@WebServlet({"/ListPersons","/ControllerServlet"})
public class ControllerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PersonService personService;
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws  ServletException, IOException{
        
        String action = request.getParameter("action");
        
        if(action != null && action.equals("edit")){
            String personId = request.getParameter("personId");
            int id = 0;
            if(personId != null){
                id = Integer.parseInt(personId);
                Person person = new Person(id);
                person = this.personService.findPersonById(person);
                
                request.setAttribute("person", person);
                
                request.getRequestDispatcher("editPerson.jsp").forward(request, response);
            }
        }else{
            this.listPersons(request,response);
        }
        List<Person> persons = personService.listPersons();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("listPersons.jsp").forward(request, response);
    }
    
    private void listPersons(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        //4. Redireccionamos cargando nuevamente el listado
        List<Person> p = personService.listPersons();
        request.setAttribute("persons",p);
        request.getRequestDispatcher("listPersons.jsp").forward(request, response);
    }
}
