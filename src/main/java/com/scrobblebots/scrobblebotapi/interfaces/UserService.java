package com.scrobblebots.scrobblebotapi.interfaces;

import com.scrobblebots.scrobblebotapi.exceptions.RecordNotFoundException;
import com.scrobblebots.scrobblebotapi.models.User;

public interface UserService {
    User AddUser(User user);
    User GetUser(String username);
    User UpdateUser(User user);
    Boolean DeleteUser(User user) throws RecordNotFoundException;
}
