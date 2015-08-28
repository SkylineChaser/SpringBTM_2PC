package com.technoficent.btm.dao;

import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.to.Status;


public interface EmployeeADAO {
	
	public Status addEmployee(Employee employee) throws Exception;
	
	public Employee getEmpoyeeDetails(String id);
	
	public Status updateEmployee(Employee employee);
	
	public Status deleteEmployeeByEmpID(String empID);
		
}