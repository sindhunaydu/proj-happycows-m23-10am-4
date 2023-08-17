package edu.ucsb.cs156.happycows.repositories;

import edu.ucsb.cs156.happycows.entities.Report;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    Iterable<Report> findAllByCommonsId(Long commonsId);
    Iterable<Report> findAll(Sort sort);
}
