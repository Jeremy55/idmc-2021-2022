package fr.unilorraine.idmc.gamescatalog.config;

import fr.unilorraine.idmc.gamescatalog.core.DBAuthProvider;
import fr.unilorraine.idmc.gamescatalog.core.MD5Checker;
import fr.unilorraine.idmc.gamescatalog.core.UserDetailsServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import static fr.unilorraine.idmc.gamescatalog.config.UsersStorage.DB;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;

// https://spring.io/guides/gs/securing-web/
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityProperties        properties;
    private final UserDetailsServiceFactory detailsFactory;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // https://stackoverflow.com/a/14020466/1107450
        // jetbrains://idea/settings?name=Editor--Code+Style
        // Enable format markers
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/v1.yml").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .anyRequest()
                .authenticated();

        // https://dzone.com/articles/spring-security-authentication
        if (properties.getStorage() == DB) {
            final var authProvider = new DBAuthProvider(detailsFactory.inDb(), new MD5Checker());
            http.authenticationProvider(authProvider);
        } else {
            http.userDetailsService(detailsFactory.inMemory());
        }

        http.httpBasic();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(OPTIONS, "/**")
                .antMatchers(GET, "/favicon.ico");
    }
}