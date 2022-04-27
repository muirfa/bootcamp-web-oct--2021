/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.dao.PersonDao;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.service.LoginUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "PersonListServletController", urlPatterns = {"/person-list"})
public class PersonListServletController extends HttpServlet {

    private PersonDao personDao =  new PersonDao();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginUtil.isNotLogin(request, response)) {
            return;
        }
        
        List<Person> persons = personDao.getPersons();
        request.setAttribute("persons", persons);
//        show person-list.jsp page
        RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/view/person-list.jsp");
        dispatcher.forward(request, response);
        
        
    }

   
}
