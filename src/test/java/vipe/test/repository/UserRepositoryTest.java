package vipe.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import vipe.test.config.TestAppConfig;

/**
 * Created by viraj on 12/27/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@WebAppConfiguration
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void sampleTest() {
    Assert.notNull(userRepository);
    Assert.notNull(new Object());
  }
}
