package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation implements EmpDao {

	@Override
	public boolean adminSearch(Employee emp) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
			String query = "select * from employees";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(Integer.parseInt(rs.getString(1))==emp.getId()) {
					if(rs.getString(5).equals("admin")&&rs.getString(4).equals(emp.getPwd())) {
						emp.setName(rs.getString(2));
						flag=true;
					}
				}
			}
			pstmt.close();
			rs.close();
			con.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean insert(Employee emp) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {	
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
				PreparedStatement pstmt = con.prepareStatement("insert into employees (name,age,pwd,role)values(?,?,?,?)");
				pstmt.setString(1, emp.getName());
				pstmt.setInt(2, emp.getAge());
				pstmt.setString(3, emp.getPwd());
				pstmt.setString(4, emp.getRole());
				int i=pstmt.executeUpdate();
				if(i!=0)
					flag=true;
				else
					flag=false;
				pstmt.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
	}

	@Override
	public boolean update(Employee emp) {
		
		boolean flag=false;
		try {	
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
				PreparedStatement pstmt = con.prepareStatement("update employees set name=?,age=?,pwd=?,role=? where id=?");
				System.out.println();
				pstmt.setString(1, emp.getName());
				pstmt.setInt(2, emp.getAge());
				pstmt.setString(3, emp.getPwd());
				pstmt.setString(4, emp.getRole());
				pstmt.setInt(5, emp.getId());
				int i=pstmt.executeUpdate();
				if(i!=0)
					flag=true;
				else
					flag=false;
				pstmt.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean delete(Employee emp) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {	
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
				PreparedStatement pstmt = con.prepareStatement("delete from employees where id=?");
				System.out.println();
				pstmt.setInt(1, emp.getId());
				int i=pstmt.executeUpdate();
				if(i!=0)
					flag=true;
				else
					flag=false;
				pstmt.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
	}

	@Override
	public List<Employee> display() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<>();
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
			String query = "select * from employees";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	
			while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setAge(Integer.parseInt(rs.getString(3)));
					emp.setPwd(rs.getString(4));
					emp.setRole(rs.getString(5));
					employeeList.add(emp);
			}
			pstmt.close();
			con.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public Employee searchById(Employee emp) {
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sapient123");
			String query = "select * from employees";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(Integer.parseInt(rs.getString(1))==emp.getId()) {
					emp.setName(rs.getString(2));
					emp.setAge(Integer.parseInt(rs.getString(3)));
					emp.setPwd(rs.getString(4));
					emp.setRole(rs.getString(5));
				}
			}
			pstmt.close();
			rs.close();
			con.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return emp;
	}

}