package com.benoitparmentier.transaction;

import com.benoitparmentier.data.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {

    @Autowired
    private ActorRepository actorRepository;

    @Transactional
    public int addThreeWonderfulActors() {
        int update = actorRepository.update("Al", "PACINO");
        update += actorRepository.update("Marlon", "BRANDO");
        update += actorRepository.update("Leonard", "DICAPRIO");
        return update;
    }

    @Transactional
    public int addTwoWonderfulActorsError() {
        int update = 0;
        update = actorRepository.update("Al", "PACINO");
        update += actorRepository.updateWithError("Marlon", "BRANDO");
        return update;
    }

}
