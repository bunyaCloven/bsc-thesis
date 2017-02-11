package co.madran.beeride.model.dao;

import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/** JpaRepository for Car. */
public interface CarRepository extends JpaRepository<Car, Long> {
  /** Lists all cars of a user. */
  List<Car> findByUser(User user);
}
