package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Location;
import co.madran.beeride.model.domain.User;

public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
	public List<Carpool> findByUser(User user);

	@Query("select cp from Carpool cp "
			+ "where cp.carx.passengerCount>cp.currentPassengers "
			+ "and cp.timex>CURRENT_TIMESTAMP")
	public List<Carpool> findNonFull(Pageable pageable);

	@Query("select cp from Carpool cp "
			+ "where cp.carx.passengerCount>cp.currentPassengers "
			+ "and cp.timex>CURRENT_TIMESTAMP "
			+ "and cp.name like concat('%',:name,'%') ")
	public List<Carpool> findNonFullByName(@Param(value = "name") String name,
			Pageable pageRequest);

	@Query("select cp from Carpool cp "
			+ "where cp.carx.passengerCount>cp.currentPassengers "
			+ "and cp.timex>CURRENT_TIMESTAMP "
			+ "and cp.name like concat('%',:name,'%') "
			+ "order by abs(cp.pathx.startLocation.latitude-:latitude)"
			+ "+abs(cp.pathx.startLocation.longitude-:longitude)")
	public List<Carpool> findNonFullFiltered(
			@Param(value = "name") String name,
			@Param(value = "latitude") Double latitude,
			@Param(value = "longitude") Double longitude, Pageable pageRequest);
}
