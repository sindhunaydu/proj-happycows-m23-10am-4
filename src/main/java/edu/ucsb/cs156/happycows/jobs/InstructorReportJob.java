package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.entities.Commons;
import edu.ucsb.cs156.happycows.entities.Report;
import edu.ucsb.cs156.happycows.repositories.CommonsRepository;
import edu.ucsb.cs156.happycows.services.ReportService;
import edu.ucsb.cs156.happycows.services.jobs.JobContext;
import edu.ucsb.cs156.happycows.services.jobs.JobContextConsumer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InstructorReportJob implements JobContextConsumer {

    @Getter
    private ReportService reportService;

    @Getter
    private CommonsRepository commonsRepository;

    @Override
    public void accept(JobContext ctx) throws Exception {
        ctx.log("Starting instructor report...");
        Iterable<Commons> allCommons = commonsRepository.findAll();

        for (Commons commons : allCommons) {
            ctx.log(String.format("Starting Commons id=%d (%s)...", commons.getId(), commons.getName()));
            Report report = reportService.createReport(commons.getId());
            ctx.log(String.format("Report %d for commons id=%d (%s) finished.", report.getId(), commons.getId(),
                    commons.getName()));
        }
        ctx.log("Instructor report done!");
    }
}