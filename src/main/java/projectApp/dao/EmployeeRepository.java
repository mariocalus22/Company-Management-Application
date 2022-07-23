package projectApp.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projectApp.dto.EmployeeProject;
import projectApp.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, e.work_hours as workHours, COUNT(pe.employee_id) as projectCount "
			+ "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id "
			+ "GROUP BY e.first_name, e.last_name, e.work_hours ORDER  BY 3 DESC")
	public List<EmployeeProject> employeeProjects();

	public Employee findByEmployeeId(long empId);
}
