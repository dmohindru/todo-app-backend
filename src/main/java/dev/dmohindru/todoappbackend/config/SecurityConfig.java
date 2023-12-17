package dev.dmohindru.todoappbackend.config;

import dev.dmohindru.todoappbackend.filter.JwtKeycloakUsernameHeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
// Try without this annotation
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // 1: Jwt Authentication Convertor
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        // Create convertor that decoded jwt and puts username and name in appropriate http headers

        httpSecurity
                // Session management
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Cors configuration
                .cors(corsConfigurer -> corsConfigurer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }))
                // CSRF configuration
                .csrf(csrfConfigurer -> csrfConfigurer.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                // Authorized Http Requests Configuration
                .authorizeHttpRequests(httpReqConfigurer ->
                        httpReqConfigurer.requestMatchers(
                                        "/api/v1/user/**",
                                        "/api/v1/todotitle/**",
                                        "/api/v1/todo/**").authenticated())
                // OAuth2 Resource server customizer
                .oauth2ResourceServer(oAuthCustomizer ->
                        oAuthCustomizer.jwt(jwtConfigurer ->
                                jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter)))
                // Add custom filter here
                .addFilterAfter(new JwtKeycloakUsernameHeaderFilter(), BearerTokenAuthenticationFilter.class);



        return httpSecurity.build();

    }
}
