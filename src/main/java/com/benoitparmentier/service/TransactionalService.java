package com.benoitparmentier.service;

import com.benoitparmentier.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {

    @Autowired
    private ActorRepository actorRepository;

    @Transactional
    public int addTwoWonderfulActors() {
        int update = actorRepository.update("Al", "PACINO");
        update += actorRepository.update("Marlon", "BRANDO");
        return update;
    }

    @Transactional
    public int addThreeWonderfulActorsRuntimeException() {
        int update = 0;
        update = actorRepository.update("Al", "PACINO");
        update += actorRepository.update("Marlon", "BRANDO");
        update += actorRepository.updateWithBadSQLGrammarException("Leonardo", "DICAPRIO");
        return update;
    }

    @Transactional
    public int addFourWonderfulActorsCheckedException() throws Exception {
        int update = 0;
        update = actorRepository.update("Al", "PACINO");
        update += actorRepository.update("Marlon", "BRANDO");
        update += actorRepository.update("Leonardo", "DICAPRIO");
        update += actorRepository.update("Joe", "Peschi");
        throw new Exception("Checked Exception test");
    }

    @Transactional(rollbackFor = Exception.class)
    public int addFiveWonderfulActorsRollBackForCheckedException() throws Exception {
        int update = 0;
        update = actorRepository.update("Al", "PACINO");
        update += actorRepository.update("Marlon", "BRANDO");
        update += actorRepository.update("Leonardo", "DICAPRIO");
        update += actorRepository.update("Joe", "Peschi");
        update += actorRepository.update("Margot", "Robbie");
        throw new Exception("Checked Exception test");
    }

}
