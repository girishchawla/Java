/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alien.servlets;

import alien.businesslogic.BlogManager;
import alien.commonobjects.models.Blog;
import alien.helpers.SessionAssister;
import alien.helpers.StringAssister;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trent
 */
@WebServlet(name = "ViewBlog", urlPatterns = {"/ViewBlog"})
public class ViewBlog extends HttpServlet {
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
        Blog blog = null;
        
        try {
            blog = BlogManager.retrieveBlog(Integer.parseInt(request.getParameter("blogId")));
        } catch (Exception ex) { }
        
        if (null != blog) {
            request.setAttribute("blog", blog);
            request.getRequestDispatcher("/WEB-INF/jsps/social/ViewBlog.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsps/errors/Generic.jsp").forward(request, response);
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
        int blogId = 0;
        String content = request.getParameter("content");

        String error = "";
        
        try {
            blogId = Integer.parseInt(request.getParameter("blogId"));
        } catch (Exception ex) {
            error = "You seem to have bastardized the blog.";
        }
        
        if (SessionAssister.loggedIn(request)) {
            if (content.isEmpty()) {
                error = "Comment is required.";
            }

            if (error.isEmpty()) {
                content = StringAssister.checkBlank(content, 255);
                
                BlogManager blogManager = new BlogManager(
                    SessionAssister.retrieveSessionUser(request).getUserName());
                try {
                    if (!blogManager.createBlogComment(blogId, content)) {
                        error = "There was an error adding your comment.";
                    }
                } catch (Exception ex) {
                    error = "There was an error adding your comment.";
                }
            }
        } else {
            error = "You must be logged in to comment.";
        }
        
        if (!error.isEmpty()) {
            SessionAssister.addError(request, error);
        } else {
            SessionAssister.clearErrors(request);
        }

        response.sendRedirect("ViewBlog?blogId=" + blogId);
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
