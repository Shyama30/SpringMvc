package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();

	public Employee getEmployee(String email);

	public void deleteEmployee(Employee employee);
}
