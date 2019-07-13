package com.bean;

public class Employee {
	
	private int id;
	private String name;
	private String pwd;
	private int age;
	private String role;
	
	
	public int getId() {
		return id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String pwd, int age, String role) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.role = role;
	}
	public Employee(int id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Employee(String name, int age, String pwd, String role) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.role = role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}