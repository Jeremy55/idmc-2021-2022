package fr.unilorraine.idmc.gamescatalog.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AuthFailException extends AuthenticationException {

    public AuthFailException() {
        super("The provided username or password are not correct");
    }
}