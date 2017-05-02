package com.benoitparmentier.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int update(String firstName, String lastName) {
        return jdbcTemplate.update("INSERT INTO actor VALUES (?, ?)", firstName, lastName);
    }

    public int updateWithError(String firstName, String lastName) {
        return jdbcTemplate.update("INSERTOUT INTO actor VALUES (?, ?)", firstName, lastName);
    }
}
