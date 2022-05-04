package com.example.zadanie.controller;

import com.example.zadanie.model.ZadanieResponse;
import com.example.zadanie.serwis.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final GithubService githubService;

    @GetMapping(path = "/users/{login}")
    public ZadanieResponse getUser(@PathVariable String login) {
        return githubService.getUser(login);
    }
}
