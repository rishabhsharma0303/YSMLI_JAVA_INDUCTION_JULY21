package com.custapp.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import com.custapp.dao.user.User;
import com.custapp.dao.user.UserNotFoundException;
import com.custapp.service.CustomerService;
import com.custapp.service.CustomerServiceImpl;
import com.custapp.service.UserService;
import com.custapp.service.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private UserService userService;
	private SessionFactory factory;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory=(SessionFactory) getServletContext().getAttribute("factory");
		userService=new UserServiceImpl(factory);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message=request.getParameter("message");
		String error=request.getParameter("error");
		request.setAttribute("message", message);
		request.setAttribute("error", error);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
		User user=userService.getUser(username, password);
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("user", user);
		
		response.sendRedirect("custcontroller.do?action=showall");
		
		}catch(UserNotFoundException ex) {
			response.sendRedirect("login");
		}
		
	}

}
