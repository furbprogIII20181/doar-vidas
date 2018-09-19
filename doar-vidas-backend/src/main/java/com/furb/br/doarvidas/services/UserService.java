package com.furb.br.doarvidas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.furb.br.doarvidas.model.User;
import com.furb.br.doarvidas.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

}