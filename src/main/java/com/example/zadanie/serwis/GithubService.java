package com.example.zadanie.serwis;

import com.example.zadanie.dto.ApiResponse;
import com.example.zadanie.infrastructure.Github;
import com.example.zadanie.infrastructure.GithubDao;
import com.example.zadanie.model.ZadanieResponse;
import com.example.zadanie.mapper.ZadanieResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubService {

    private static final Integer COUNTER = 1;
    private final ApiGateway apiGateway;
    private final CalculationsService calculationsService;
    private final GithubDao githubDao;
    private final ZadanieResponseMapper zadanieResponseMapper;

    public ZadanieResponse getUser(String login) {
        ZadanieResponse response = null;
        try {
            ApiResponse gitHubUserInfo = apiGateway.getGitHubUserInfo(login);
            updateH2(gitHubUserInfo);
            Integer calculations = calculationsService.calculations(gitHubUserInfo);
            response = zadanieResponseMapper.map(gitHubUserInfo, calculations);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return response;
    }

    private void updateH2(ApiResponse gitHubUserInfo) {
        Github loginToUpdate = findLogin(gitHubUserInfo);
        if (loginToUpdate != null) {
            update(loginToUpdate);
        } else {
            githubDao.save(new Github(gitHubUserInfo.getLogin(), COUNTER));
        }
    }

    private Github findLogin(ApiResponse gitHubUserInfo) {
        return githubDao.findAll().stream()
                .filter(element -> gitHubUserInfo.getLogin().equals(element.getLogin()))
                .findFirst()
                .orElse(null);
    }

    private void update(Github loginToUpdate) {
        Integer counter = loginToUpdate.getCounter() + COUNTER;
        Github github = new Github(loginToUpdate.getLogin(), counter);
        githubDao.update(github);
    }

}
