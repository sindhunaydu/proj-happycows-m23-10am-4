package edu.ucsb.cs156.happycows.repositories;

import edu.ucsb.cs156.happycows.entities.Profit;
import edu.ucsb.cs156.happycows.entities.UserCommons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitRepository extends CrudRepository<Profit, Long> {
    Iterable<Profit> findAllByUserCommons(UserCommons userCommons);
}
