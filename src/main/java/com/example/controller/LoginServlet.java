package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO = new UserDAO();

	
	/**
	 * metodo que recime el request y el respnse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userDAO.validateUser(username, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("dashboard.jsp");
		} else {
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
