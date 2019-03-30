package com.akhambir.service;

import com.akhambir.dao.UserDao;
import com.akhambir.model.Role;
import com.akhambir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private MailService mailService;

    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User register(User user) {
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setToken(getToken());
        user.setStatus(User.UserStatus.PENDING_VERIFICATION);
        User saved = userDao.addUser(user);
        mailService.send(saved);
        return saved;
    }

    @Override
    public User emailVerification(String token) {
        User user = userDao.getByToken(token);
        user.setStatus(User.UserStatus.ACTIVE);
        userDao.updateUser(user);
        return user;
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByUsername(username);
        List<SimpleGrantedAuthority> roles = user.getRoles().stream()
                .map(Role::getRoleName)
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}