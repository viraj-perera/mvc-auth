package vipe.test.service;

import vipe.test.model.User;

public interface UserService {
  User findBySSO(String ssoId);
}
