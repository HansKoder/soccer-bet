package com.hans.bet.soccer_service.auth.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "SOCC3R_B3T";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public String create (String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("soccer_bet")
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
                .sign(ALGORITHM);
    }

    public boolean isValid (String jwt) {
        try {
            JWT.require(ALGORITHM).build().verify(jwt);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    public String username (String jwt) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }

}
