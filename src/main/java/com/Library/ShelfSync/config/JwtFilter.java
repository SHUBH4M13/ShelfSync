package com.Library.ShelfSync.config;

import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.repository.UserRepo;
import com.Library.ShelfSync.services.Jwtservice;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final Jwtservice jwtservice;
    private final UserRepo userRepo;

    public JwtFilter(Jwtservice jwtservice, UserRepo userRepo) {
        this.jwtservice = jwtservice;
        this.userRepo = userRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException, java.io.IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {

            String email = jwtservice.extractEmail(token);

            if (email != null && jwtservice.isTokenValid(token, email)) {

                UserEntity user = userRepo.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException("User not found"));

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                Collections.singletonList(
                                        new SimpleGrantedAuthority(
                                                user.getRole()
                                                        .getRoleName()
                                                        .name()
                                        )
                                )
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

        } catch (Exception e) {

            SecurityContextHolder.clearContext();

        }

        filterChain.doFilter(request, response);
    }
}