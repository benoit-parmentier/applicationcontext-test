package com.benoitparmentier.repository;

import com.benoitparmentier.model.MovieEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaMovieRepository {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public MovieEntity findById(long movieId){
        return entityManager.find(MovieEntity.class, movieId);
    }

}
