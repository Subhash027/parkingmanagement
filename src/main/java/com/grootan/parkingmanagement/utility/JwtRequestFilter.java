//package com.grootan.parkingmanagement.utility;
//
//import com.grootan.parkingmanagement.service.JwtUserDetailsService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//    @Autowired
//    JwtUserDetailsService jwtUserDetailService;
//
//    @Autowired
//    JwtUtility jwtUtility;
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
//    {
//        final String authorizationHeader = request.getHeader("Groot-Parking-Lot_Authorization");
//
//        String username = null;
//        String jwtToken = null;
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwtToken = authorizationHeader.substring(7);
//            username = jwtUtility.getUsernameFromToken(jwtToken);
//        }
//        // Token validation
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.jwtUserDetailService.loadUserByUsername(username);
//
//            if (Boolean.TRUE.equals(jwtUtility.validateToken(jwtToken, userDetails))) {
//                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
