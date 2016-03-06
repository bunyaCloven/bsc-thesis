package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Seat;
import co.madran.beeride.model.domain.User;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	Seat findByUserAndCarpool(User user, Carpool carpool);

	@Query("select s.carpool from Seat s where s.user=:user")
	List<Carpool> findCarpools(@Param(value = "user") User user,
			Pageable pageable);
}
