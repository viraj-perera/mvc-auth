package vipe.test.repository;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@Repository
public class JpaTokenRepositoryImpl implements PersistentTokenRepository {

  @PersistenceContext
  private EntityManager em;

  public void createNewToken(PersistentRememberMeToken token) {

  }

  public void updateToken(String series, String tokenValue, Date lastUsed) {

  }

  public PersistentRememberMeToken getTokenForSeries(String seriesId) {
    return null;
  }

  public void removeUserTokens(String username) {

  }
}
