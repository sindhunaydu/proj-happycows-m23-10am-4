package edu.ucsb.cs156.happycows.strategies;

import edu.ucsb.cs156.happycows.entities.Commons;
import edu.ucsb.cs156.happycows.entities.UserCommons;

public interface CowHealthUpdateStrategy {

    public double calculateNewCowHealth(
            Commons commons,
            UserCommons user,
            int totalCows
    );

    public String getDisplayName();
    public String getDescription();
}
