package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.User;

public interface CarRepository extends JpaRepository<Car, Long> {
	public List<Car> findByUser(User user);
}
