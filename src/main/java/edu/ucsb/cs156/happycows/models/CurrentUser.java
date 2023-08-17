package edu.ucsb.cs156.happycows.models;

import edu.ucsb.cs156.happycows.entities.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class CurrentUser {
  private User user;
  private Collection<? extends GrantedAuthority> roles;
}
