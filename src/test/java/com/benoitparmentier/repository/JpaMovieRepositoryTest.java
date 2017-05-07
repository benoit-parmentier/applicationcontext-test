package com.benoitparmentier.repository;

import com.benoitparmentier.config.AppConfig;
import com.benoitparmentier.model.MovieEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class JpaMovieRepositoryTest {

    @Autowired
    private JpaMovieRepository jpaMovieRepository;

    @Test
    public void test(){
        MovieEntity movie = jpaMovieRepository.findById(1);
        Assertions.assertThat(movie.getName()).isEqualTo("The Godfather");
    }

}
