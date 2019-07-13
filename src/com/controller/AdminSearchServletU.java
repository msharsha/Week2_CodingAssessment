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
 * Servlet implementation class AdminUpdateServlet
 */
public class AdminSearchServletU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchServletU() {
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
		// TODO Auto-generated method stub
		//System.out.println("hi");
		int id = Integer.parseInt(request.getParameter("f1"));
		Employee e =new Employee();
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDao obj = (EmpDao)factory.getBean("empdao");
		e.setId(id);
		e = (obj.searchById(e));
		request.setAttribute("eid", e.getId());
		request.setAttribute("ename", e.getName());
		request.setAttribute("eage", e.getAge());
		request.setAttribute("epwd", e.getPwd());
		request.setAttribute("erole", e.getRole());
		RequestDispatcher rd =request.getRequestDispatcher("AdminSearchUpdate.jsp");
		rd.forward(request,response); 
	}

}