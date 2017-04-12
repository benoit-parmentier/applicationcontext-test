package com.benoitparmentier.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionalService transactionalService;

    @Transactional
    public void test(){
        jdbcTemplate.update("INSERT INTO actor VALUES ('AL', 'PACINO')");
        jdbcTemplate.update("INSERT INTO ac VALUES ('Marlon', 'PACINO')");
    }

}
