package com.example.zadanie.serwis;

import com.example.zadanie.dto.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculationsService {

    public Integer calculations(ApiResponse apiUserInfo) {
        if (apiUserInfo.getFollowers() == 0) {
            return 0;
        }
        return (6 / apiUserInfo.getFollowers()) * (2 + apiUserInfo.getPublic_repos());
    }
}
