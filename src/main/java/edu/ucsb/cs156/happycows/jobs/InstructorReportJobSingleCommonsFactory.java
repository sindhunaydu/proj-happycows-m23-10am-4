package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.services.ReportService;
import edu.ucsb.cs156.happycows.services.jobs.JobContextConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorReportJobSingleCommonsFactory {

    @Autowired
    private ReportService reportService;

    public JobContextConsumer create(long commonsId) {
        return new InstructorReportJobSingleCommons(commonsId, reportService);
    }
  
}
