package dev.connellrobert.ims.repo;

import java.util.Optional;

import dev.connellrobert.ims.model.IMSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<IMSUser, Long> {
	
	Optional<IMSUser> findByUsername(String username);
	
	void deleteByUsername(String username);
}
