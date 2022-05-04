package com.example.zadanie.mapper;

import com.example.zadanie.dto.ApiResponse;
import com.example.zadanie.model.ZadanieResponse;
import org.springframework.stereotype.Component;

@Component
public class ZadanieResponseMapper {

    public ZadanieResponse map(ApiResponse apiUserResponse, Integer calculations) {
        return ZadanieResponse.builder()
                .id(apiUserResponse.getId())
                .login(apiUserResponse.getLogin())
                .name(apiUserResponse.getName())
                .type(apiUserResponse.getType())
                .avatarUrl(apiUserResponse.getAvatar_url())
                .createdAt(apiUserResponse.getCreated_at())
                .calculations(calculations)
                .build();
    }
}
