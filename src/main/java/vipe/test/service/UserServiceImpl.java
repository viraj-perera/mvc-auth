package vipe.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vipe.test.model.User;
import vipe.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  public User findBySSO(String ssoId) {
    return userRepository.findBySsoId(ssoId);
  }
}
