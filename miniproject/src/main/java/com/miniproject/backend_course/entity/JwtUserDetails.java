package com.miniproject.backend_course.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;

  @Id
  @GeneratedValue
  private  Long id;
  private  String username;
  private  String password;
  //@ElementCollection(targetClass=List.class)
  //private  List<SimpleGrantedAuthority> authorities;
  
  protected JwtUserDetails() {
	  
  }

  public JwtUserDetails(Long id, String username, String password/*, String role*/) {
    this.id = id;
    this.username = username;
    this.password = password;

    /*List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(role));

    this.authorities = authorities;*/
  }
  

  public void setPassword(String password) {
	this.password = password;
}
  

public void setId(Long id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

@JsonIgnore
  public Long getId() {
    return id;
  }

  //@Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /*@JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }


  /*@Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }*/

  @Override
  public boolean isEnabled() {
    return true;
  }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

}


