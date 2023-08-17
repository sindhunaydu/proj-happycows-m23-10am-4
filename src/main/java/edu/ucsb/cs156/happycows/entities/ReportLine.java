package edu.ucsb.cs156.happycows.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "report_lines")

public class ReportLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long reportId;
    private long userId;

    private String username;
    private double totalWealth;
    private int numOfCows;
    private double avgCowHealth;
    private int cowsBought;
    private int cowsSold;
    private int cowDeaths;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
