package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.repositories.CommonsRepository;
import edu.ucsb.cs156.happycows.services.ReportService;
import edu.ucsb.cs156.happycows.services.jobs.JobContextConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorReportJobFactory {

    @Autowired
    private ReportService reportService;

    @Autowired
    private CommonsRepository commonsRepository;

    public JobContextConsumer create() {
        return new InstructorReportJob(reportService, commonsRepository);
    }

}
