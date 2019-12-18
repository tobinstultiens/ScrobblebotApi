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
    public void AddUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User GetUser(String username) {
        return userRepository.findById(username).get();
    }

    @Override
    public void UpdateUser(User user) {
        Optional<User> employee = userRepository.findById(user.getDiscordUsername());

        if(employee.isPresent())
        {
            User newEntity = employee.get();
            newEntity.setDiscordUsername(user.getDiscordUsername());
            newEntity.setLastFmUsername(user.getLastFmUsername());

            userRepository.save(newEntity);
        }
    }

    @Override
    public void DeleteUser(User user) throws RecordNotFoundException {
        Optional<User> employee = userRepository.findById(user.getDiscordUsername());

        if(employee.isPresent())
        {
            userRepository.deleteById(user.getDiscordUsername());
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
