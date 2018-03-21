package com.phani.restclient.services.impl;

import com.phani.restclient.domain.User;
import com.phani.restclient.services.ApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUsersBeforeImpl() {
        List<User> data = apiService.getUsers(3);
        assertEquals(null, data);
    }

    @Test
    public void getUsersAfterImpl() {
        List<User> data = apiService.getUsers(1);
        assertEquals(2, data.size());
    }
}