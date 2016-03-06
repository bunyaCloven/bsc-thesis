package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.User;

public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
	public List<Carpool> findByUser(User user);

	@Query("select cp from Carpool cp where cp.carx.passengerCount>cp.carx.currentPassengers")
	public List<Carpool> findNonFull(Pageable pageable);
}
