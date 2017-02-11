package co.madran.beeride.model.dao;

import co.madran.beeride.model.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** JpaRepository for User. */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  /** Finds a user by its username. */
  User findByUsername(String username);
}
