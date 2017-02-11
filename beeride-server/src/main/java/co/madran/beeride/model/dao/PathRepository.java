package co.madran.beeride.model.dao;

import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/** JpaRepository for Path. */
public interface PathRepository extends JpaRepository<Path, Long> {
  /** Finds all paths declared by user. */
  List<Path> findByUser(User user);
}
