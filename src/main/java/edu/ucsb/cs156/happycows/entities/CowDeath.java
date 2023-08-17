package edu.ucsb.cs156.happycows.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "cowdeath")
public class CowDeath {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="commons_id")
  private long commonsId;

  @Column(name="user_id")
  private long userId;
  
  private LocalDateTime zonedDateTime;
  private Integer cowsKilled; 
  private double avgHealth; 

}
