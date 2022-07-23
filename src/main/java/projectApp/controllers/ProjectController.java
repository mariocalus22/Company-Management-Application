package projectApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectApp.entities.Employee;
import projectApp.entities.Project;
import projectApp.services.EmployeeService;
import projectApp.services.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projServ;
	
	@Autowired
	EmployeeService emServ;
	
	@GetMapping
	public String showProjects(Model model) {
		//extragere proiecte din baza de date
		List<Project> projects = projServ.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String showProjectForm(Model model) {
		
		Project aProject = new Project();
		//extragere angajati din baza de date
		List<Employee> employees = emServ.getAll();
		//adaugarea obiectului aProject in model
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project ,Model model) {
		//salvare proiect
		projServ.save(project);
		
	
		

		return"redirect:/projects ";
	}
	
	@GetMapping("/update")
	public String updateProject(@RequestParam("id") long projId, Model model ) {
		
	Project proj = projServ.findByProjectId(projId);
	
	model.addAttribute("project", proj);
	
	return "projects/new-project";
		
	}
	
	@GetMapping("/delete")
	public String deleteProject(@RequestParam("id") long projId, Model model ) {
		
	Project proj = projServ.findByProjectId(projId);
	
	projServ.delete(proj);
	
	return "redirect:/projects ";
		
	}

}
