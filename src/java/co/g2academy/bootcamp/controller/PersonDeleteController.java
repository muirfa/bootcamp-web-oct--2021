/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.dao.PersonDao;
import co.g2academy.bootcamp.service.LoginUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "PersonDeleteController", urlPatterns = {"/person-delete"})
public class PersonDeleteController extends HttpServlet {
    private PersonDao personDao = new PersonDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginUtil.isNotLogin(request, response)) {
            return;
        }
        Integer id = Integer.valueOf(request.getParameter("id"));
        personDao.delete(id);
        response.sendRedirect("person-list");
    }

}
