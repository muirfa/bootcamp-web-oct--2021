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
@WebServlet(name = "PersonEditController", urlPatterns = {"/person"})
public class PersonEditController extends HttpServlet {
    private PersonDao personDao  = new PersonDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id =  Integer.valueOf(request.getParameter("id"));
        Person person =  personDao.getPersonById(id);
        if (person != null) {
            request.setAttribute("person", person);
            RequestDispatcher  dispatcher = request.getRequestDispatcher("/WEB-INF/view/person-edit.jsp");
            dispatcher.forward(request, response);
            return;
        }
        response.sendRedirect("person-list");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginUtil.isNotLogin(request, response)) {
            return;
        }
        Integer id = Integer.valueOf(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String password =  request.getParameter("password");
        String confirmPassword =  request.getParameter("confirmPassword");
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "password did not match");
            Person person = personDao.getPersonById(id);
            RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/view/person-edit.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        Person person = personDao.getPersonById(id);
        if (person != null) {
            person.setName(userName);
            person.setPassword(password);
            personDao.save(person);
        }
        response.sendRedirect("person-list");
    }

    

}
