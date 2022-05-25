//package com.grootan.parkingmanagement.service;
//
//import com.grootan.parkingmanagement.model.dto.UserDTO;
//import com.grootan.parkingmanagement.model.entity.DAOUser;
//import com.grootan.parkingmanagement.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Slf4j
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userDao;
//
//    @Autowired
//    private PasswordEncoder bcryptEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DAOUser user = userDao.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                new ArrayList<>());
//    }
//
//    public DAOUser addUser(UserDTO user) {
//        DAOUser addNewUser = new DAOUser();
//        addNewUser.setUsername(user.getUsername());
//        addNewUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        log.info("New User Created");
//        return userDao.save(addNewUser);
//    }
//}
