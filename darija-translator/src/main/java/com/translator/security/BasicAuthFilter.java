package com.translator.security;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Provider 
public class BasicAuthFilter implements ContainerRequestFilter {

    private static final String AUTH_HEADER = "Authorization";
    private static final String AUTH_PREFIX = "Basic ";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        List<String> authHeader = requestContext.getHeaders().get(AUTH_HEADER);

        if (authHeader != null && authHeader.size() > 0) {
            String authToken = authHeader.get(0);
            if (authToken.startsWith(AUTH_PREFIX)) {
                String decodedString = new String(Base64.getDecoder().decode(authToken.substring(AUTH_PREFIX.length())));
                
                
                String[] split = decodedString.split(":");
                String username = split[0];
                String password = split[1];

                
                if ("admin".equals(username) && "password123".equals(password)) {
                    return; 
                }
            }
        }

        
        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity("User cannot access the resource.")
                .build());
    }
}