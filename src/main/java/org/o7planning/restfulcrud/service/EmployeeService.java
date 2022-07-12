package org.o7planning.restfulcrud.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;

@Path("/employees")
public class EmployeeService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees_JSON() {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> listOfPosition = dao.getAllEmployees();
		return listOfPosition;
	}

	@GET
	@Path("/{empNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("empNo") int empNo) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.getEmployee(empNo);
		return employee;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.aggiungiEmployee(emp);
		return employee;
	}

	@PUT
	@Path("/{empNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee emp, @PathParam("empNo") int empNo) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.aggiornaEmployee(emp, empNo);
		return emp;
	}

	@DELETE
	@Path("/{empNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("empNo") int empNo) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.eliminaEmployee(empNo);
	}

}
