package com.custapp.web.controller;

import java.util.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.custapp.dao.customer.Customer;
import com.custapp.service.CustomerService;
import com.custapp.service.CustomerServiceImpl;

//custcontroller?action=showall
@WebServlet("/custcontroller.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerService customerService;
	private SessionFactory factory;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory=(SessionFactory) getServletContext().getAttribute("factory");
		customerService=new CustomerServiceImpl(factory);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("showall")) {
			List<Customer> customers = customerService.allCustomers();
			request.setAttribute("customers", customers);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/allcustomers.jsp");
			rd.forward(request, response);

		} else if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			customerService.deleteCustomer(id);
			response.sendRedirect("custcontroller.do?action=showall");
		} else if (action.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			Customer customer = customerService.getCustomerById(id);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/views/updatecustomer.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("add")) {
			request.getRequestDispatcher("/WEB-INF/views/addcustomer.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String dobString = request.getParameter("dob");
		String email = request.getParameter("email");

		SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");

		Date dob = null;
		try {
			dob = formate.parse(dobString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// for new customer
		if (id == 0) {
			Customer customer = new Customer(name, address, mobile, email, dob);
			customerService.addCustomer(customer);
		} else {
			Customer customer = customerService.getCustomerById(id);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setMobile(mobile);
			customerService.updateCustomer(id, customer);
		}
		response.sendRedirect("custcontroller.do?action=showall");

	}

}
