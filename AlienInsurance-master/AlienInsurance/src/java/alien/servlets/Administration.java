/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alien.servlets;

import alien.businesslogic.AdminManager;
import alien.commonobjects.models.User;
import alien.commonobjects.models.UserTypes;
import alien.helpers.SessionAssister;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trent
 */
@WebServlet(name = "Administration", urlPatterns = {"/Administration"})
public class Administration extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (SessionAssister.isRole(request, UserTypes.Administrator)) {
            String error = "";
            
            AdminManager adminManager = new AdminManager(
                    SessionAssister.retrieveSessionUser(request).getUserName());
            
            Collection<User> users = null,
                    employees = null;
            
            try {
                users 
                        = adminManager.retrieveUsers();
                employees 
                        = adminManager.retrieveEmployees();
            } catch (Exception ex) {
                error = "There was a problem retrieve user data.";
            }
            
            if (error.isEmpty()) {
                request.setAttribute("users", users);
                request.setAttribute("employees", employees);
            }
            
            request.getRequestDispatcher("/WEB-INF/jsps/admin/Administration.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsps/errors/AdminOnly.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsps/admin/Administration.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
