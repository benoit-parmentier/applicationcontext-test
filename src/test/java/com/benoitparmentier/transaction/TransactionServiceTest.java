package com.benoitparmentier.transaction;

import com.benoitparmentier.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        try {
            transactionalService.test();
        } catch (Exception e) {
            Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM actor", Integer.class);
            assert count == 0;
        }

    }


}
