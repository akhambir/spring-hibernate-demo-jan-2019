package com.akhambir.service;

import com.akhambir.model.User;

public interface UserService {

    User getByUsername(String username);

    User register(User user);
}
