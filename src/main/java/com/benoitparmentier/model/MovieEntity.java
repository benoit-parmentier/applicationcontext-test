package com.benoitparmentier.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
