package projectApp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	
	private long projectId;
	
	private String name;
	
	private String stage; 
	
	private String description;
	
	private int budget;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns=@JoinColumn(name="project_id"),
				inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<Employee> employees;
	
	public Project() {
		
	}

	public Project(String name, String stage, String description, int budget) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
		this.budget = budget;
	}
	
	

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public void addEmployee(Employee emp) {
		if(employees==null) {
			employees = new ArrayList<>();
		}
		
		employees.add(emp);
	}
	
	

}
