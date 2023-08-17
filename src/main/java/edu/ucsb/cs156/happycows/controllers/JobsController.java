package edu.ucsb.cs156.happycows.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucsb.cs156.happycows.entities.jobs.Job;
import edu.ucsb.cs156.happycows.jobs.*;
import edu.ucsb.cs156.happycows.repositories.jobs.JobsRepository;
import edu.ucsb.cs156.happycows.services.jobs.JobContextConsumer;
import edu.ucsb.cs156.happycows.services.jobs.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Jobs")
@RequestMapping("/api/jobs")
@RestController
public class JobsController extends ApiController {
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    UpdateCowHealthJobFactory updateCowHealthJobFactory;

    @Autowired
    MilkTheCowsJobFactory milkTheCowsJobFactory;

    @Autowired
    SetCowHealthJobFactory setCowHealthJobFactory;

    @Autowired
    InstructorReportJobFactory instructorReportJobFactory;

    @Autowired
    InstructorReportJobSingleCommonsFactory instructorReportJobSingleCommonsFactory;

    @Operation(summary = "List all jobs")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public Iterable<Job> allJobs() {
        Iterable<Job> jobs = jobsRepository.findAll();
        return jobs;
    }

    @Operation(summary = "List all jobs")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all/pageable")
    public Page<Job> allJobsPaged(
         @Parameter(name="page") @RequestParam int page,
         @Parameter(name="size") @RequestParam int size
    ) {
        Page<Job> jobs = jobsRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
        return jobs;
    }

    @Operation(summary = "Launch Test Job (click fail if you want to test exception handling)")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/testjob")
    public Job launchTestJob(
        @Parameter(name="fail") @RequestParam Boolean fail, 
        @Parameter(name="sleepMs") @RequestParam Integer sleepMs
    ) {
        TestJob testJob = TestJob.builder()
        .fail(fail)
        .sleepMs(sleepMs)
        .build();

        return jobService.runAsJob(testJob);
    }

    @Operation(summary = "Launch Job to Milk the Cows (click fail if you want to test exception handling)")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/milkthecowjob")
    public Job launchTestJob(
    ) {
        JobContextConsumer milkTheCowsJob = milkTheCowsJobFactory.create();
        return jobService.runAsJob(milkTheCowsJob);
    }

    @Operation(summary = "Launch Job to Update Cow Health")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/updatecowhealth")
    public Job updateCowHealth(
    ) { 
        JobContextConsumer updateCowHealthJob = updateCowHealthJobFactory.create();
        return jobService.runAsJob(updateCowHealthJob);
    }

    @Operation(summary = "Launch Job to Set Cow Health")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/setcowhealth")
    public Job setCowHealth(
        @Parameter(name="commonsID") @RequestParam Long commonsID, 
        @Parameter(name="health") @RequestParam double health
    ) { 
        JobContextConsumer setCowHealthJob = setCowHealthJobFactory.create(commonsID, health);
        return jobService.runAsJob(setCowHealthJob);
    }

    @Operation(summary = "Launch Job to Produce Instructor Report")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/instructorreport")
    public Job instructorReport(
    ) { 
        InstructorReportJob instructorReportJob = (InstructorReportJob) instructorReportJobFactory.create();
        return jobService.runAsJob(instructorReportJob);
    }

    @Operation(summary = "Launch Job to Produce Instructor Report for a single commons")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/launch/instructorreportsinglecommons")
    public Job instructorReportSingleCommons(
         @Parameter(name="commonsId") @RequestParam Long commonsId
    ) { 

        InstructorReportJobSingleCommons instructorReportJobSingleCommons = (InstructorReportJobSingleCommons) instructorReportJobSingleCommonsFactory.create(commonsId);
        return jobService.runAsJob(instructorReportJobSingleCommons);
    }
}
