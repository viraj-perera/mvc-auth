package vipe.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="app_user")
public class User implements Serializable {

  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

//  @NotEmpty
  @Column(name="sso_id", unique=true, nullable=false)
  private String ssoId;

//  @NotEmpty
  @Column(name="password", nullable=false)
  private String password;

//  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

//  @NotEmpty
  @Column(name="last_name", nullable=false)
  private String lastName;

//  @NotEmpty
  @Column(name="email", nullable=false)
  private String email;

//  @NotEmpty
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "app_user_user_role",
          joinColumns = { @JoinColumn(name = "user_id") },
          inverseJoinColumns = { @JoinColumn(name = "user_role_id") })
  private Set<UserRole> userProfiles = new HashSet<UserRole>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSsoId() {
    return ssoId;
  }

  public void setSsoId(String ssoId) {
    this.ssoId = ssoId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<UserRole> getUserProfiles() {
    return userProfiles;
  }

  public void setUserProfiles(Set<UserRole> userProfiles) {
    this.userProfiles = userProfiles;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof User))
      return false;
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (ssoId == null) {
      if (other.ssoId != null)
        return false;
    } else if (!ssoId.equals(other.ssoId))
      return false;
    return true;
  }

  /*
   * DO-NOT-INCLUDE passwords in toString function.
   * It is done here just for convenience purpose.
   */
  @Override
  public String toString() {
    return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
            + ", firstName=" + firstName + ", lastName=" + lastName
            + ", email=" + email + "]";
  }



}