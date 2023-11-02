package com.example.GDV.auth.config;


import com.example.GDV.auth.token.Token;
import com.example.GDV.auth.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final TokenRepository tokenRepository;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    pr("********************Autorisation = "+request.getHeader("Authorization")+"***************");
    if (request.getServletPath().contains("/api/auth")) {
      pr("*****************************1***************************");
      filterChain.doFilter(request, response);
      return;
    }
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      pr("*****************************2***************************");
      filterChain.doFilter(request, response);
      return;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      pr("*****************************3*****user = "+userEmail+"**********************");
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
      pr("user details ****************************)"+userDetails.getUsername());
      var isTokenValid = tokenRepository.findByToken(jwt)
          .map(t -> !t.isExpired() && !t.isRevoked())
          .orElse(false);
      pr("*************** 9able find by token**********jwt ="+jwt+"********************");
      Token tb=tokenRepository.findByToken(jwt).get();
      pr("*************** apres find by token******************************");
      pr(" token recupurer expired "+tb.isExpired()+" **** revok***"+tb.isRevoked());
      pr(" istokenvalid :"+jwtService.isTokenValid(jwt, userDetails) );
      pr(" is valid 2"+ (true && isTokenValid));
      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
        pr("*****************************4***************************");
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.getAuthorities()
        );
        for(GrantedAuthority ga:userDetails.getAuthorities()){
          pr("roles ******"+ga.getAuthority());
        }
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );pr(" 1 ");
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
      pr("*************jwtService.isTokenValid(jwt, userDetails) && isTokenValid************");
    }
    filterChain.doFilter(request, response);
  }
  private void pr(Object o){
    System.out.println(o);
  }
}
