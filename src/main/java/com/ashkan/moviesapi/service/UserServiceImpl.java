package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieRepository;
import com.ashkan.moviesapi.dao.UserRepository;

import com.ashkan.moviesapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User user = null;

        if (result.isPresent()) {
            user = result.get();
        }
        else {
            throw new RuntimeException("Did not find the user- " + theId);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
}
