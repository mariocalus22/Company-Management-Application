package projectApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projectApp.dto.ChartData;
import projectApp.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	public Project findByProjectId(long projId);

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ChartData>getProjectStatus();
}
