package com.pitang.desafio.lucasmarques.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pitang.desafio.lucasmarques.exceptions.InvalidTokenException;
import com.pitang.lucasmarques.dto.LoginDTO;

public abstract class JWTUtil {

    private static final String SECRET = "$upeRS3KR&7KKeY";

    private static final String ISSUER = "Pitang";

    public static String generateToken(final UserDTO userDTO) {
        LocalDateTime expiryTime = LocalDateTime.now().plusHours(1);
        final Date expiresAt = Date.from(expiryTime.atZone(ZoneId.systemDefault()).toInstant());
        return JWT.create() //
            .withIssuer(ISSUER) //
            .withClaim("login", userDTO.getLogin()) //
            .withClaim("password", userDTO.getPassword()) //
            .withExpiresAt(expiresAt) //
            .sign(Algorithm.HMAC256(SECRET.getBytes()));
    }

    public static boolean isValid(final String token) throws InvalidTokenException {
        if (token == null || token.isBlank()) {
            return false;
        }
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET.getBytes())) //
                .withIssuer(ISSUER) //
                .withClaim("login", getClaimByName(token, "login", String.class)) //
                .withClaim("password", getClaimByName(token, "password", String.class)) //
                .build();
            verifier.verify(token);
            return false;
        } catch (final Exception e) {
            return false;
        }
    }

    public static <T> T getClaimByName(final String token, final String name, final Class<T> type) {
        final DecodedJWT decode = JWT.decode(token);
        final Claim valor = decode.getClaim(name);
        return valor.isNull() ? null : valor.as(type);
    }

}
