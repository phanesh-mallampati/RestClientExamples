package com.phani.restclient.controllers;

import com.phani.restclient.domain.User;
import com.phani.restclient.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Controller
public class UserController {

    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"/", "/index", ""})
    public String getIndex(Model model){
        return "index";
    }

    @PostMapping("/users")
    public String getUsers( Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = new Integer(map.get("limit").get(0));
        List<User> userList = apiService.getUsers(limit);
        model.addAttribute("users", userList);
        return "userList";
    }
}
