package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.User;

public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
	public List<Carpool> findByUser(User user);
}
