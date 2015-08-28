package com.technoficent.btm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.to.Status;
import com.technoficent.btm.to.StatusConstants;

@SuppressWarnings(value = "unchecked")
@Repository("employeeADao")
public class EmployeeADAOImpl implements EmployeeADAO {

	@PersistenceContext(unitName = "jpa-poc1")
	private EntityManager entityManager;
	
	public void persist(Object entity) {
		getEntityManager().persist(entity);
	}

	public void delete(Object entity) {
		getEntityManager().remove(entity);
	}
	
	private EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unused")
	private Session getSession(){
		return getEntityManager().unwrap(Session.class);
	}
	
	@Override
	public Employee getEmpoyeeDetails(String id) {
		Query query = getEntityManager().createQuery(" from Employee emp WHERE emp.employeeID = :employeeID");
		query.setParameter("employeeID", id);
		
		List<Employee> employees = query.getResultList();
		if(employees != null && !employees.isEmpty()){
			return employees.get(0);
		}
		return null;
	}

	public Status updateEmployee(Employee employee){
		Status status = null;
		try {
			getEntityManager().merge(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception e) {
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			e.printStackTrace();
		}
		return status;
	}
	
	public Status deleteEmployeeByEmpID(String empID) {
		Status status = null;
		try {
			Employee employee = getEmpoyeeDetails(empID);
			getEntityManager().remove(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex){
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			ex.printStackTrace();
		}
		return status;
	}

	@Override
	public Status addEmployee(Employee employee) throws Exception {
		Status status = null;
		getEntityManager().persist(employee);
		
		status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		return status;
	}
	
	/*@Override
	public Status addEmployee(Employee employee) throws Exception {
		Status status = null;
		getSession().persist(employee);
		status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		return status;
	}*/
	
}
