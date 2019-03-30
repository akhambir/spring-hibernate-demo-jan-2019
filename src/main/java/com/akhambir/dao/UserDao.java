package com.akhambir.dao;

import com.akhambir.model.User;

public interface UserDao {

    User getByUsername(String username);

    User addUser(User user);

    User getByToken(String token);

    User updateUser(User user);
}
