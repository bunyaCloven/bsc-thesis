package co.madran.beeride.model.dao;

import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Seat;
import co.madran.beeride.model.domain.User;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/** JpaRepository for Seat. */
public interface SeatRepository extends JpaRepository<Seat, Long> {
  /** Finds the seat of a user in a Carpool. */
  Seat findByUserAndCarpool(User user, Carpool carpool);

  /** Finds future Carpools which the user has a Seat in. */
  @Query("select s.carpool from Seat s where s.user=:user and s.carpool.timex>CURRENT_TIMESTAMP")
  List<Carpool> findCarpools(@Param(value = "user") User user, Pageable pageable);

  Carpool findByCarpoolAndUser(Carpool carpool, User user);
}
