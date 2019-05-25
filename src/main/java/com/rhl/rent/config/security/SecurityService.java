package com.rhl.rent.config.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}