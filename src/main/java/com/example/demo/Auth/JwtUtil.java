package com.example.demo.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long JWT_EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    // יצירת Token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "user"); // ניתן להוסיף קליימים נוספים

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME)) // תוקף ל-10 שעות
                .signWith(key)
                .compact();
    }

    // אימות Token
    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new RuntimeException("JWT token is expired");
        } catch (Exception e) {
            throw new RuntimeException("Invalid JWT token");
        }
    }

    public boolean isTokenValid(String token, String username) {
        final String extractedUsername = extractAllClaims(token).getSubject();
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

  }


