package co.madran.beeride;

import co.madran.beeride.model.dao.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class Starter {
  public static void main(final String... args) {
    SpringApplication.run(Starter.class, args);
  }
}
