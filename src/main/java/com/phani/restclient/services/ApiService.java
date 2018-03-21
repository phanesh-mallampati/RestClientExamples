package com.phani.restclient.services;

import com.phani.restclient.domain.User;

import java.util.List;

public interface ApiService {
    List<User> getUsers(Integer limit);
}
