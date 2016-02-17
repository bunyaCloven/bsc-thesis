package co.madran.beeride.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.madran.beeride.model.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
