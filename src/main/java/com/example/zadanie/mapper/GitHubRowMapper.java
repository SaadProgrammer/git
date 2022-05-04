package com.example.zadanie.mapper;

import com.example.zadanie.infrastructure.Github;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GitHubRowMapper implements RowMapper<Github> {

    @Override
    public Github mapRow(ResultSet rs, int rowNum) throws SQLException {
        Github github = new Github();
        github.setLogin(rs.getString("LOGIN"));
        github.setCounter(rs.getInt("REQUEST_COUNT"));
        return github;
    }
}
