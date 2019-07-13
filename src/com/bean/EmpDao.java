package com.bean;
import java.util.List;

public interface EmpDao {
	
	public boolean adminSearch(Employee e);
	public Employee searchById(Employee e);
	public boolean insert(Employee e);
	public boolean update(Employee e);
	public boolean delete(Employee e);
	public List<Employee> display();
}