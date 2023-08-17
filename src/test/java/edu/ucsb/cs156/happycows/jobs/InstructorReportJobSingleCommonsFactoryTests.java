package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.services.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestClientTest(InstructorReportJobSingleCommonsFactory.class)
@AutoConfigureDataJpa
public class InstructorReportJobSingleCommonsFactoryTests {

    @MockBean
    ReportService reportService;
 
    @Autowired
    InstructorReportJobSingleCommonsFactory InstructorReportJobSingleCommonsFactory;

    @Test
    void test_create() throws Exception {

        // Act
        InstructorReportJobSingleCommons instructorReportJobSingleCommons = (InstructorReportJobSingleCommons) InstructorReportJobSingleCommonsFactory.create(17L);

        // Assert
        assertEquals(17L,instructorReportJobSingleCommons.getCommonsId());
        assertEquals(reportService,instructorReportJobSingleCommons.getReportService());
    }
}

