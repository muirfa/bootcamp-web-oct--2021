/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class LoginUtil {
    public static boolean isNotLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login");
            return true;
        }
        Boolean isLogin = (Boolean) session.getAttribute("login");
        if (isLogin ==  null || isLogin == false) {
            response.sendRedirect("login");
            return true;
        }
        return false;
    }
}
