package ru.fintechwizards.finwiz.Security;

import com.nimbusds.jwt.SignedJWT;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.text.ParseException;
import java.time.Instant;

import ru.fintechwizards.finwiz.Models.User;

public class TokenService {

  private final JwtEncoder jwtEncoder;

  public TokenService(JwtEncoder jwtEncoder) {
    super();
    this.jwtEncoder = jwtEncoder;
  }

  public String generateAccessToken(User usrDetails) {
    Instant now = Instant.now();
    JwtClaimsSet claims = JwtClaimsSet.builder()
        .issuer("self")
        .issuedAt(now)
        .subject(usrDetails.getUsername())
        .build();
    return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }

  public String parseToken(String token) {
    try {
      SignedJWT decodedJWT = SignedJWT.parse(token);
      String subject = decodedJWT.getJWTClaimsSet().getSubject();
      return subject;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}