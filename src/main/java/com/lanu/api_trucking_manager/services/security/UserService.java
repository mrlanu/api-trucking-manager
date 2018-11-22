package com.lanu.api_trucking_manager.services.security;

import com.lanu.api_trucking_manager.entities.security.User;

public interface UserService {

    User save(User user);

    boolean existByUsername(String username);
}
