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
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("t1"));
		String pwd = request.getParameter("t2");
		System.out.println(id+pwd);
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDao obj = (EmpDao)factory.getBean("empdao");
		Employee e = new Employee(id, pwd);
		System.out.println(id+pwd);
		if(obj.adminSearch(e)){
			request.setAttribute("loginName", e.getName());
			RequestDispatcher rd =request.getRequestDispatcher("ValidAdminLogin.jsp");
			rd.forward(request,response); 
		} 
		else {
			RequestDispatcher rd =request.getRequestDispatcher("InvalidAdminLogin.jsp");
			rd.forward(request,response); 
		}
	}

}