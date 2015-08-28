package com.technoficent.btm.services;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.technoficent.btm.entities.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class EmployeeTest {

	@Autowired
	private EmployeeSEI empService;
	
	private static final String EMP_ID = "9001";
	
	public EmployeeSEI getEmpService() {
		return empService;
	}

	@Test(expected=Exception.class)
	public void test1addEmployee() throws Exception {
		Employee Employee = new Employee();
		Employee.setEmployeeID(EMP_ID);
		Employee.setEmployeeDept("90");
		Employee.setEmployeeName("Test User");
		getEmpService().addEmployee(Employee);
	}
	
	@Test
	public void test2getEmpoyeeDetails() throws Exception {
		Employee employee = getEmpService().getEmpoyeeDetails(EMP_ID, "A");
		Assert.assertNotNull("Employee is Null", employee);
	}
	
	@Test
	public void test3getEmpoyeeDetails() throws Exception {
		Employee employee = getEmpService().getEmpoyeeDetails(EMP_ID, "B");
		Assert.assertNotNull("Employee is Null", employee);
	}
	
	
	//@Test
	public void test4updateEmployee() throws Exception {
		Employee Employee = new Employee();
		Employee.setEmployeeID(EMP_ID);
		Employee.setEmployeeDept("91");
		Employee.setEmployeeName("Test User1");
		
		getEmpService().updateEmployee(Employee);
	}
	
	//@Test
	public void test5deleteEmployeeByEmpID() throws Exception {
		
		getEmpService().deleteEmployeeByEmpID(EMP_ID);
	}
	
}
