/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.dao.StudentDao;
import co.g2academy.bootcamp.entity.Student;
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
@WebServlet(name = "StudentListController", urlPatterns = {"/student-list"})
public class StudentListController extends HttpServlet {

    private StudentDao studentDao = new StudentDao();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginUtil.isNotLogin(request, response)) {
            return;
        }
        
        List<Student> students = studentDao.getStudents();
        request.setAttribute("students", students);

        RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/view/student-list.jsp");
        dispatcher.forward(request, response);
        
        
    }


}
