package com.example.zadanie.infrastructure;

import com.example.zadanie.mapper.GitHubRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GithubDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public List<Github> findAll() {
        try {
            return jdbcTemplate.query("select * from github ", new GitHubRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            ex.getStackTrace();
        }
        return null;
    }

    public int save(Github github) {
        return jdbcTemplate.update("insert into github (login, request_count) " + " values(?,?) ", github.getLogin(), github.getCounter());
    }

    public int update(Github github) {
        return jdbcTemplate.update("update github set request_count = ? where login = ? ", github.getCounter(), github.getLogin());
    }

}
