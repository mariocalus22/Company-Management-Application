package projectApp.homePage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomePage {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void homePageReturnsTitles_thenSuccess() {
		String homePage = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertEquals(homePage.contains("Projects Created"), true);
		assertEquals(homePage.contains("Employees"), true);
		assertEquals(homePage.contains("Home Page"), true);
	}
}
