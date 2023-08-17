package edu.ucsb.cs156.happycows.repositories;

import edu.ucsb.cs156.happycows.entities.CowDeath;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowDeathRepository extends CrudRepository<CowDeath, Long> {
    
}