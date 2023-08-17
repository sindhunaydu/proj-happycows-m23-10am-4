package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.repositories.CommonsRepository;
import edu.ucsb.cs156.happycows.repositories.UserCommonsRepository;
import edu.ucsb.cs156.happycows.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestClientTest(UpdateCowHealthJobFactory.class)
@AutoConfigureDataJpa
public class UpdateCowHealthJobFactoryTests {

    @MockBean
    CommonsRepository commonsRepository;

    @MockBean
    UserCommonsRepository userCommonsRepository;

    @MockBean
    UserRepository userRepository;

    @Autowired
    UpdateCowHealthJobFactory updateCowHealthJobFactory;

    @Test
    void test_create() throws Exception {

        // Act
        UpdateCowHealthJob updateCowHealthJob = (UpdateCowHealthJob) updateCowHealthJobFactory.create();

        // Assert
        assertEquals(commonsRepository,updateCowHealthJob.getCommonsRepository());
        assertEquals(userCommonsRepository,updateCowHealthJob.getUserCommonsRepository());
        assertEquals(userRepository,updateCowHealthJob.getUserRepository());

    }
}

