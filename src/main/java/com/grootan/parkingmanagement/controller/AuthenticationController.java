//package com.grootan.parkingmanagement.controller;
//
//import com.grootan.parkingmanagement.model.domain.AuthenticateRequest;
//import com.grootan.parkingmanagement.model.domain.AuthenticateResponse;
//import com.grootan.parkingmanagement.model.domain.UserResponse;
//import com.grootan.parkingmanagement.model.dto.UserDTO;
//import com.grootan.parkingmanagement.service.JwtUserDetailsService;
//import com.grootan.parkingmanagement.utility.JwtUtility;
//import io.swagger.v3.oas.annotations.Operation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.security.RolesAllowed;
//
//@Slf4j
//@RestController
//public class AuthenticationController {
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    JwtUtility jwtUtility;
//
//    @RolesAllowed("ADMIN")
//    @Operation(summary = "New User Registration", description = "Rest service to register new user", tags = "Create User")
//    @PostMapping(value = "/register", produces = "application/json")
//    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserDTO newUser) {
//        log.info("creating access for username: {}", newUser.getUsername());
//        jwtUserDetailsService.addUser(newUser);
//        return new ResponseEntity<>(new UserResponse("User created successfully"), HttpStatus.OK);
//    }
//
//    @Operation(summary = "Access Token", description = "Rest service to create access token", tags = "Get Access")
//    @PostMapping(value = "/token", produces = "application/json")
//    public ResponseEntity<AuthenticateResponse> createsAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
//                        authenticateRequest.getPassword())
//        );
//
//        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
//
//        final String jwtToken = jwtUtility.generateToken(userDetails);
//
//        return new ResponseEntity<>(new AuthenticateResponse(jwtToken), HttpStatus.OK);
//    }
//}
