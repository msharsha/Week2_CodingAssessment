package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmpDao;
import com.bean.Employee;

/**
 * Servlet implementation class AdminDeleteServlet
 */
public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("f1"));
		String name = request.getParameter("f2");
		int age = Integer.parseInt(request.getParameter("f3"));
		String pwd = request.getParameter("f4");
		String role = request.getParameter("f5");
		Employee e = new Employee(id, name, pwd, age, role);
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDao obj = (EmpDao)factory.getBean("empdao");
		if(obj.delete(e)) {
			RequestDispatcher rd =request.getRequestDispatcher("ValidAdminDelete.jsp");
			rd.forward(request,response); 
		}
		else {
			RequestDispatcher rd =request.getRequestDispatcher("InvalidAdminDelete.jsp");
			rd.include(request, response); 
		}
	}

}
