package dev.dmohindru.todoappbackend.security;

import dev.dmohindru.todoappbackend.constants.RequestHeaderKey;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtAuthenticationConverter jwtAuthenticationConverter;
    public CustomJwtAuthenticationConverter(JwtAuthenticationConverter jwtAuthenticationConverter) {
        this.jwtAuthenticationConverter = jwtAuthenticationConverter;
    }
    @Override
    public AbstractAuthenticationToken convert(Jwt source) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String username = (String) source.getClaims().get("email");
        String name = (String) source.getClaims().get("name");

        request.setAttribute(RequestHeaderKey.NAME.getKeyName(), name);
        request.setAttribute(RequestHeaderKey.USER_NAME.getKeyName(), username);


        return jwtAuthenticationConverter.convert(source);
    }

}