package co.madran.beeride.integration.config.annotation;

import co.madran.beeride.controller.CarHandler;
import co.madran.beeride.integration.config.TestDatabaseConfig;
import co.madran.beeride.model.dao.UserRepository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDatabaseConfig.class })
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan(basePackageClasses = CarHandler.class)
@EnableWebMvc
@Target(ElementType.TYPE)
public @interface IntegrationTest {
}
