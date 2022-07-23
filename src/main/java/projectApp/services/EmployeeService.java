package projectApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectApp.dao.EmployeeRepository;
import projectApp.dto.EmployeeProject;
import projectApp.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}

	public Employee findByEmployeeId(long empId) {
		
		return empRepo.findByEmployeeId(empId);
	}

	public void delete(Employee emp) {
		 empRepo.delete(emp);
		
	}

}
