package edu.ucsb.cs156.happycows.repositories;

import edu.ucsb.cs156.happycows.entities.ReportLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportLineRepository extends CrudRepository<ReportLine, Long> {
    Iterable<ReportLine> findAllByReportId(Long reportId);
}
