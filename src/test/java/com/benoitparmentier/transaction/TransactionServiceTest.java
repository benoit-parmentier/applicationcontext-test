package com.benoitparmentier.transaction;

import com.benoitparmentier.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void test_addTwoWonderfulActors() {
        int countService = transactionalService.addTwoWonderfulActors();
        int countBDD = jdbcTemplate.queryForObject("SELECT count(*) FROM actor", Integer.class);
        assert countService == 2;
        assert countBDD == 2;
    }

    @Test
    public void test_addThreeWonderfulActorsRuntimeException() {
        int countService = 0;
        int countBDD = 0;
        try {
            countService = transactionalService.addThreeWonderfulActorsRuntimeException();
            //We will never be there
            assert true == false;
        } catch (RuntimeException e) {
            countBDD = jdbcTemplate.queryForObject("SELECT count(*) FROM actor", Integer.class);
            Assertions.assertThat(countService).isEqualTo(0);
            Assertions.assertThat(countBDD).isEqualTo(0);
        }
    }

    @Test
    @Transactional
    public void test_addFourWonderfulActorsCheckedException() {
        int countBDD = 0;
        try {
            transactionalService.addFourWonderfulActorsCheckedException();
            //We will never be there
            assert true == false;
        } catch (Exception e) {
            countBDD = jdbcTemplate.queryForObject("SELECT count(*) FROM actor", Integer.class);
            Assertions.assertThat(countBDD).isEqualTo(4);
        }
    }

    @Test
    public void test_addFiveWonderfulActorsRollBackForCheckedException() {
        int countBDD = 0;
        try {
            transactionalService.addFiveWonderfulActorsRollBackForCheckedException();
            //We will never be there
            assert true == false;
        } catch (Exception e) {
            countBDD = jdbcTemplate.queryForObject("SELECT count(*) FROM actor", Integer.class);
            Assertions.assertThat(countBDD).isEqualTo(0);
        }
    }



}
