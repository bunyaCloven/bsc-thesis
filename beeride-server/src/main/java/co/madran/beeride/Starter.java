package co.madran.beeride;

import co.madran.beeride.config.DatabaseConfig;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan(basePackageClasses = { User.class, DatabaseConfig.class })
@SpringBootApplication
public class Starter {
  public static void main(final String... args) {
    SpringApplication.run(Starter.class, args);
  }
}
