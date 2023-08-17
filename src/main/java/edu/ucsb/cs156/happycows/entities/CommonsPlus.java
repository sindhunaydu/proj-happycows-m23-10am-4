package edu.ucsb.cs156.happycows.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonsPlus {
    private Commons commons;
    private Integer totalCows;
    private Integer totalUsers;
}