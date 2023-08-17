package edu.ucsb.cs156.happycows.repositories;

import edu.ucsb.cs156.happycows.entities.Commons;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CommonsRepository extends CrudRepository<Commons, Long> {
    @Query("SELECT sum(uc.numOfCows) from user_commons uc where uc.commons.id = :commonsId")
    Optional<Integer> getNumCows(Long commonsId);

    @Query("SELECT COUNT(*) FROM user_commons uc WHERE uc.commons.id = :commonsId")
    Optional<Integer> getNumUsers(Long commonsId);

}
