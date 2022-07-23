package projectApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import projectApp.dao.EmployeeRepository;
import projectApp.dao.ProjectRepository;
import projectApp.dto.ChartData;
import projectApp.dto.EmployeeProject;
import projectApp.entities.Employee;
import projectApp.entities.Project;

@Controller
public class HomeController {
	
	
	
	@Autowired
	ProjectRepository projectRep;
	
	@Autowired
	EmployeeRepository employeeRep;

	@GetMapping("/")
	public String showMainPage(Model model) throws JsonProcessingException {
		
		

		//extragere din baza de date a proiectelor
		List<Project> projects = projectRep.findAll();	
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectStatus = projectRep.getProjectStatus();
		
		//convertire projectStatus in json
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonData = objectMapper.writeValueAsString(projectStatus);
		//[["NOTSTARTED", 3],["INPROGRESS", 2], ["COMPLETED", 1]]
		
		model.addAttribute("StatusProjectCount", jsonData);
		
		//extragere din baza de date a proiectelor
		List<EmployeeProject> empPjCount = employeeRep.employeeProjects();
		model.addAttribute("emplListProjCount", empPjCount);
		

		return "main/home";
		
		
	}
	
	
}
