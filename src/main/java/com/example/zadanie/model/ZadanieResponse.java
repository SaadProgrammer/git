package com.example.zadanie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZadanieResponse {

    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private Date createdAt;
    private Integer calculations;
}
