package projectApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectApp.dao.EmployeeRepository;
import projectApp.entities.Employee;
import projectApp.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String showEmployees(Model model) {
		//extragere angajati din baza de date
		List<Employee>employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		//afisare lista angajati
		return "employees/employeesList";
	}
	
	@GetMapping("/new")
	public String showEmployeeForm(Model model) {
		//creare obiect angajat
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/CreateEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(Model model, Employee employee) {
		//salvare angajat in baza de date
		employeeService.save(employee);
		
		return "redirect:/employees";
		
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("id") long empId ,Model model) {
		
		Employee emp = employeeService.findByEmployeeId(empId);
		
		model.addAttribute("employee", emp);
		
		return "employees/CreateEmployee";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long empId ,Model model) {
		
		Employee emp = employeeService.findByEmployeeId(empId);
		
		employeeService.delete(emp);
		
		return "redirect:/employees";
		
	}

}
