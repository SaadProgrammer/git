package com.example.zadanie.infrastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Github {

    private String login;
    private Integer counter;

    public Github() {
    }

    public Github(String login, Integer counter) {
        this.login = login;
        this.counter = counter;
    }
}
