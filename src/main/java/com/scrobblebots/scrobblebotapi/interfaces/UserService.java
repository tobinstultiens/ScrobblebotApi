package com.scrobblebots.scrobblebotapi.interfaces;

import com.scrobblebots.scrobblebotapi.exceptions.RecordNotFoundException;
import com.scrobblebots.scrobblebotapi.models.User;

public interface UserService {
    void AddUser(User user);
    User GetUser(String username);
    void UpdateUser(User user);
    void DeleteUser(User user) throws RecordNotFoundException;
}
