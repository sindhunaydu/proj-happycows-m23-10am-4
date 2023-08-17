package edu.ucsb.cs156.happycows.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor()
public class HealthUpdateStrategyInfo {
    private String name;
    private String displayName;
    private String description;

}
