package edu.ucsb.cs156.happycows.repositories.jobs;

import edu.ucsb.cs156.happycows.entities.jobs.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobsRepository extends CrudRepository<Job, Long> {
    public Page<Job> findAll(Pageable pageable);
}
