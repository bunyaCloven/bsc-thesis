package co.madran.beeride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import co.madran.beeride.model.dao.UserRepository;

@EnableWebMvc
@ComponentScan
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableAutoConfiguration
public class Starter {
	public static void main(final String... args) {
		SpringApplication.run(Starter.class, args);
	}
}
