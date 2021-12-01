package fr.unilorraine.idmc.gamescatalog.core;
import fr.unilorraine.idmc.gamescatalog.exceptions.AuthFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

@RequiredArgsConstructor
public class DBAuthProvider implements AuthenticationProvider {

    private final UserDetailsService detailsService;
    private final PasswordChecker    checker;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication.getCredentials() == null) {
            return null;
        }

        final var details = detailsService.loadUserByUsername(authentication.getPrincipal().toString());

        if(checker.areEqual(details.getPassword(), authentication.getCredentials().toString())) {
            final var token = (UsernamePasswordAuthenticationToken) authentication;

            // need to re-create because : Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead
            return new UsernamePasswordAuthenticationToken(token.getPrincipal(), details.getPassword(), details.getAuthorities());
        }

        throw new AuthFailException();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}