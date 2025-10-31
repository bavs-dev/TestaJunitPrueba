package com.example.controller;


import com.example.dao.UserDAO;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet") 
public class UserServlet extends HttpServlet{
	
	  private UserDAO userDAO = new UserDAO();

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if ("delete".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            userDAO.deleteUser(id);
	            response.sendRedirect("dashboard.jsp");
	        } else if ("edit".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            request.setAttribute("user", userDAO.getUserById(id));
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        User user = new User(id, username, password);
	        if (id == 0) {
	            userDAO.insertUser(user);
	        } else {
	            userDAO.updateUser(user);
	        }
	        response.sendRedirect("dashboard.jsp");
	    }

}
