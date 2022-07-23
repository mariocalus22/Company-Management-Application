package projectApp.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import projectApp.dao.ProjectRepository;
import projectApp.entities.Employee;
import projectApp.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"})
				})
public class ProjectRepositoryIntegrationTest {
	@Autowired
	ProjectRepository proRep;
	
	@Autowired
	EmployeeRepository emplRep;
	
	@Test
	public void ifCreationOfProjectsAndEmployees_thenSuccess() {
		Project newProject = new Project("Increase Team", "COMPLETE", "Have a team of 40 members",345);
		proRep.save(newProject);
		
		Employee newEmpl = new Employee("Alin", "Andreica", "alin@gmail.com",13);
		emplRep.save(newEmpl);
		
		assertEquals(4, proRep.findAll().size());
		assertEquals(6, emplRep.findAll().size());
	}
}
