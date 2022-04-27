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
@WebServlet(name = "StudentEditController", urlPatterns = {"/student"})
public class StudentEditController extends HttpServlet {
    private StudentDao studentDao = new StudentDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id =  Integer.valueOf(request.getParameter("id"));
        Student student =  studentDao.getStudentById(id);
        if (student != null) {
            request.setAttribute("student", student);
            RequestDispatcher  dispatcher = request.getRequestDispatcher("/WEB-INF/view/student-edit.jsp");
            dispatcher.forward(request, response);
            return;
        }
        response.sendRedirect("student-list");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginUtil.isNotLogin(request, response)) {
            return;
        }
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        String fullname = request.getParameter("fullname");
        String address =  request.getParameter("address");
        String status = request.getParameter("status");
        Integer physics = Integer.valueOf(request.getParameter("physics"));
        Integer calculus = Integer.valueOf(request.getParameter("calculus"));
        Integer biology = Integer.valueOf(request.getParameter("biology"));
        
        
        Student student = studentDao.getStudentById(id);
        if (student != null) {
            student.setFullname(fullname);
            student.setAddress(address);
            student.setStatus(status);
            student.setPhysics(physics);
            student.setCalculus(calculus);
            student.setBiology(biology);
            studentDao.save(student);
        }
        response.sendRedirect("student-list");
    }


}
