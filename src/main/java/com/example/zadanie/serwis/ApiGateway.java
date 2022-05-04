package com.example.zadanie.serwis;

import com.example.zadanie.dto.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ApiGateway {

    private static final String GIT_HUB_URL = "https://api.github.com/users/";
    private final RestTemplate rs = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiResponse getGitHubUserInfo(String login) {
        String url = GIT_HUB_URL + login;
        ResponseEntity<String> response = rs.getForEntity(url, String.class);
        ApiResponse apiResponse = mapResponse(response);
        return apiResponse;
    }

    private ApiResponse mapResponse(ResponseEntity<String> response) {
        ApiResponse apiResponse = null;
        try {
            apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

}
