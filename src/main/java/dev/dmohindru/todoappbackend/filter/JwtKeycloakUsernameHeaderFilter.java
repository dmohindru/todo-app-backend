package dev.dmohindru.todoappbackend.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtKeycloakUsernameHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String jwtToken = authorization.substring("Bearer ".length());


        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);

        mutableHttpServletRequest.addHeader("username", "dmohindru@gmail.com");
        mutableHttpServletRequest.addHeader("name", "Dhruv Mohindru");


        filterChain.doFilter(mutableHttpServletRequest, response);

    }

    class MutableHttpServletRequest extends HttpServletRequestWrapper {
        private final Map<String, String> customHeaders = new HashMap<>();
        public MutableHttpServletRequest(HttpServletRequest request) {
            super(request);
        }

        public void addHeader(String name, String value) {
            this.customHeaders.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            String headerValue = customHeaders.get(name);
            if (headerValue != null) {
                return headerValue;
            }
            return super.getHeader(name);
        }

    }
}
