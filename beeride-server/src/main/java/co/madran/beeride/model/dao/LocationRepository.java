package co.madran.beeride.model.dao;

import co.madran.beeride.model.domain.Location;

import org.springframework.data.jpa.repository.JpaRepository;

/** JpaRepository for Location. */
public interface LocationRepository extends JpaRepository<Location, Long> {
}
