package vipe.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vipe.test.model.User;
import vipe.test.model.UserRole;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

  static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

  @Autowired
  private UserService userService;

  @Transactional(readOnly=true)
  public UserDetails loadUserByUsername(String ssoId)
          throws UsernameNotFoundException {
    logger.info("SSOID : {}", ssoId);
    User user = userService.findBySSO(ssoId);
    logger.info("User : {}", user);
    if(user==null){
      logger.info("User not found");
      throw new UsernameNotFoundException("Username not found");
    }
    return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
            true, true, true, true, getGrantedAuthorities(user));
  }


  private List<GrantedAuthority> getGrantedAuthorities(User user){
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    for(UserRole userProfile : user.getUserProfiles()){
      logger.info("UserProfile : {}", userProfile);
      authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
    }
    logger.info("authorities : {}", authorities);
    return authorities;
  }

}