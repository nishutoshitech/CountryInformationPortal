package com.cip.countryinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cip.countryinfo.dao.UserDAO;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDAO userDao = new UserDAO();
		boolean result = userDao.authenticateUser(userName, password);

		if (result == true) {
			response.sendRedirect("loginsuccess.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}