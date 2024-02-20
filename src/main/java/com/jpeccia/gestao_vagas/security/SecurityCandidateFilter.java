package com.jpeccia.gestao_vagas.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecurityCandidateFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                SecurityContextHolder.getContext().setAuthentication(null);
                String header = request.getHeader("Authorization");

                if(header != null) {

                }

                filterChain.doFilter(request, response);
                
    }
    
}
