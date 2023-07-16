package com.example.foodtracker.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@WebFilter("/*")
@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    private static final String USER = "user";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getSession().getAttribute(USER) == null && !checkAuthPaths(request)) {
            response.sendRedirect("/reg");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean checkAuthPaths(HttpServletRequest request) {
        String pathInfo = request.getRequestURI();
        return pathInfo.contains("/reg") || pathInfo.contains("/auth");
    }

}