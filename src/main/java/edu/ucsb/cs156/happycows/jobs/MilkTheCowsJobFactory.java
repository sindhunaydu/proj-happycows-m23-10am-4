package edu.ucsb.cs156.happycows.jobs;

import edu.ucsb.cs156.happycows.repositories.CommonsRepository;
import edu.ucsb.cs156.happycows.repositories.ProfitRepository;
import edu.ucsb.cs156.happycows.repositories.UserCommonsRepository;
import edu.ucsb.cs156.happycows.repositories.UserRepository;
import edu.ucsb.cs156.happycows.services.jobs.JobContextConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilkTheCowsJobFactory {

    @Autowired
    private CommonsRepository commonsRepository;

    @Autowired
    private UserCommonsRepository userCommonsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfitRepository profitRepository;

    public JobContextConsumer create() {
        return new MilkTheCowsJob(
                commonsRepository,
                userCommonsRepository,
                userRepository,
                profitRepository);
    }
}
