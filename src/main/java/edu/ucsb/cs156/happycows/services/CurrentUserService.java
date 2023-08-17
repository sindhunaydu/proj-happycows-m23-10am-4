package edu.ucsb.cs156.happycows.services;

import edu.ucsb.cs156.happycows.entities.User;
import edu.ucsb.cs156.happycows.models.CurrentUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public abstract class CurrentUserService {
  public abstract User getUser();
  public abstract CurrentUser getCurrentUser();
  public abstract Collection<? extends GrantedAuthority> getRoles();

  public final boolean isLoggedIn() {
    return getUser() != null;
  }

}
