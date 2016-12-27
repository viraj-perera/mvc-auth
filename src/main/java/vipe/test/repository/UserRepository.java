package vipe.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vipe.test.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

  public User findBySsoId(String ssoId);

}
