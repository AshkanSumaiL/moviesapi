package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.exceptions.NotFound.NotFoundException;
import com.ashkan.moviesapi.repositories.UserRepository;
import com.ashkan.moviesapi.entities.User;
import com.ashkan.moviesapi.services.interfaces.UserService;
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
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user;
        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new NotFoundException("Users", id);
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
