package com.benoitparmentier.data;

import com.benoitparmentier.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CacheableService {

    public static int COUNTALL = 0;
    public static int COUNT = 0;

    @Cacheable("characters")
    public List<String> loadAllCharacters() {
        System.out.println("##################################loadAllCharacters#########################################");
        COUNTALL++;
        return new ArrayList<>();
    }

    @Cacheable(value="characters")
    public String loadActor(Actor actor) {
        System.out.println("##################################loadACharacter#########################################");
        COUNT++;
        if (actor.getFirstName() == "m") {
            return "Marlon Brando";
        } else if (actor.getFirstName() == "a") {
            return "Al Pacino";
        }
        return "";
    }

}
