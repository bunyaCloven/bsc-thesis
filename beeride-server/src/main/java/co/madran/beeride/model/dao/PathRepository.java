package co.madran.beeride.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

public interface PathRepository extends JpaRepository<Path, Long> {
	public List<Path> findByUser(User user);
}
