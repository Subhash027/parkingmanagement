//package com.grootan.parkingmanagement.config;
//
//import com.grootan.parkingmanagement.service.JwtUserDetailsService;
//import com.grootan.parkingmanagement.utility.JwtRequestFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter
//{
//    @Autowired
//    private JwtAuthenticationEntryPointConfig jwtAuthenticationEntryPoint;
//
//    @Autowired
//    JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    JwtRequestFilter jwtRequestFilter;
//
//    private static final String[] AUTH_WHITELIST =
//            {
//                    "/swagger-ui/**",
//                    "/api/swaggerTerms",
//                    "/grootan-parking-system/api-docs/**",
//                    "/register",
//                    "/token",
//                    "/ui/**"
//            };
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
////                .antMatchers(AUTH_WHITELIST).permitAll()
//                .anyRequest().permitAll()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.headers().frameOptions().disable();
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
