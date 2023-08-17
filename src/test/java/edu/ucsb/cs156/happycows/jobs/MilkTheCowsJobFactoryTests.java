package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.repositories.CommonsRepository;
import edu.ucsb.cs156.happycows.repositories.ProfitRepository;
import edu.ucsb.cs156.happycows.repositories.UserCommonsRepository;
import edu.ucsb.cs156.happycows.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestClientTest(MilkTheCowsJobFactory.class)
@AutoConfigureDataJpa
public class MilkTheCowsJobFactoryTests {

    @MockBean
    CommonsRepository commonsRepository;

    @MockBean
    UserCommonsRepository userCommonsRepository;

    @MockBean
    UserRepository userRepository;

    @MockBean
    ProfitRepository profitRepository;

    @Autowired
    MilkTheCowsJobFactory MilkTheCowsJobFactory;

    @Test
    void test_create() throws Exception {

        // Act
        MilkTheCowsJob milkTheCowsJob = (MilkTheCowsJob) MilkTheCowsJobFactory.create();

        // Assert
        assertEquals(commonsRepository,milkTheCowsJob.getCommonsRepository());
        assertEquals(userCommonsRepository,milkTheCowsJob.getUserCommonsRepository());
        assertEquals(userRepository,milkTheCowsJob.getUserRepository());
        assertEquals(profitRepository,milkTheCowsJob.getProfitRepository());

    }
}

