package projectApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectApp.dao.ProjectRepository;
import projectApp.dto.ChartData;
import projectApp.entities.Project;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}

	public Project findByProjectId(long projId) {
		// TODO Auto-generated method stub
		return proRepo.findByProjectId(projId);
	}

	public void delete(Project proj) {
		// TODO Auto-generated method stub
		proRepo.delete(proj);
	}


}
