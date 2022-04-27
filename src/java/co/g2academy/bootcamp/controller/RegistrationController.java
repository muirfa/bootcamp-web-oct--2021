/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.dao.PersonDao;
import co.g2academy.bootcamp.entity.Person;
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
@WebServlet(name = "RegistrationController", urlPatterns = {"/registration"})
public class RegistrationController extends HttpServlet {

    
    private PersonDao personDao = new PersonDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        show login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String confirmPassword =  request.getParameter("confirmPassword");
        
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Password did not match");
            request.setAttribute("userName", userName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
            dispatcher.forward(request, response);
            return;
        }
        Person person = new Person();
        person.setName(userName);
        person.setPassword(password);
        personDao.save(person);
        
        response.sendRedirect("login");
        
    }

    
}
