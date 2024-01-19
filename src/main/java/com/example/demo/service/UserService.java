package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return (List<User>) userRepository.saveAll(users);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> unwrapUser = userRepository.findById(id);
        if (unwrapUser.isPresent()) {
            return unwrapUser.get();
        } else {
            throw  new NotFoundException(String.format("User id = %s is not found", id));
        }
    }

    public User updateUserById(User user, Long id) {
        Optional<User> userFound = userRepository.findById(id);

        if (userFound.isPresent()) {
            User userUpdate = userFound.get();
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setAge(user.getAge());
            return userRepository.save(user);
        } else {
            throw new NotFoundException(String.format("User id = %s is not found", id));
        }
    }

    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return String.format("User id = %s is deleted", id);
    }
}
