package com.miniproject.backend_course.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

    //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYzNTQ4MjY5NiwiaWF0IjoxNjM0ODc3ODk2fQ.RrE5b0n21JWJWHg1UhMzKg-dg3Qg2P2niSh8stQlun2X4GhDSRkZtMW_BZ2l4O_ifMFPtJrtJXTAb_yRFk0Vhw
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

