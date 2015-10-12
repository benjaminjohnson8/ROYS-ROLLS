package raysrentals.co.uk.rays_rentals.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {
		TestApplicationConfig.class,
		TestDataSourceConfig.class, JpaConfig.class, 
		SecurityConfig.class, 
		RestConfig.class,
		

		})
public abstract class DAOTestsConfigurationAware {
}
