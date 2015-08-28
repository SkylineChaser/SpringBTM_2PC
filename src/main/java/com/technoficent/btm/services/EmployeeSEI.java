package com.technoficent.btm.services;
import com.technoficent.btm.entities.Employee;

public interface EmployeeSEI {
	
	public void addEmployee(Employee employee) throws Exception;
	
	public Employee getEmpoyeeDetails(String id, String type);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployeeByEmpID(String empID);
		
}