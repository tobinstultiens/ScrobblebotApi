package com.scrobblebots.scrobblebotapi.services;

import com.scrobblebots.scrobblebotapi.exceptions.RecordNotFoundException;
import com.scrobblebots.scrobblebotapi.models.User;
import com.scrobblebots.scrobblebotapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements com.scrobblebots.scrobblebotapi.interfaces.UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User AddUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User GetUser(String username) {
        return userRepository.findById(username).get();
    }

    @Override
    public User UpdateUser(User user) {
        Optional<User> employee = userRepository.findById(user.getDiscordUsername());

        if(employee.isPresent())
        {
            User newEntity = employee.get();
            newEntity.setDiscordUsername(user.getDiscordUsername());
            newEntity.setLastFmUsername(user.getLastFmUsername());

            userRepository.save(newEntity);
            return newEntity;
        }
        return null;
    }

    @Override
    public Boolean DeleteUser(User user)  {
        Optional<User> employee = userRepository.findById(user.getDiscordUsername());

        if(employee.isPresent())
        {
            userRepository.deleteById(user.getDiscordUsername());
            return true;
        } else {
            return false;
        }
    }
}
