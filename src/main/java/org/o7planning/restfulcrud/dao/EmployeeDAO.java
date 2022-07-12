package org.o7planning.restfulcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.o7planning.restfulcrud.model.Employee;

public class EmployeeDAO {

	public EmployeeDAO() {
		super();
	}

	private EntityManager init() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager;
	}

	public List<Employee> getAllEmployees() {
		EntityManager entityManager = this.init();
		TypedQuery<Employee> query = entityManager.createQuery("Select e from employee e", Employee.class);
		List<Employee> employees = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return employees;
	}

	public Employee getEmployee(int empNo) {

		EntityManager entityManager = this.init();
		Employee employee = (Employee) entityManager.find(Employee.class, Integer.valueOf(empNo));

		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

	public Employee aggiornaEmployee(Employee emp, int empNo) {

		EntityManager entityManager = this.init();

		Employee employee = (Employee) entityManager.find(Employee.class, empNo);
		employee.setEmpName(emp.getEmpName());
		employee.setPosition(emp.getPosition());

		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();

		return employee;
	}

	public void eliminaEmployee(int empNo) {

		EntityManager entityManager = this.init();

		Employee employee = (Employee) entityManager.find(Employee.class, Integer.valueOf(empNo));
		entityManager.remove(employee);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Employee aggiungiEmployee(Employee emp) {
		EntityManager entityManager = this.init();

		Employee employee = new Employee();

		employee.setEmpName(emp.getEmpName());

		employee.setPosition(emp.getPosition());

		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		entityManager.close();
		return employee;
	}

}