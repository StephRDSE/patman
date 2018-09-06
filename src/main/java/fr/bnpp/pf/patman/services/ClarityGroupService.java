package fr.bnpp.pf.patman.services;

import java.util.List;
import java.util.Optional;

import fr.bnpp.pf.patman.model.entities.ClarityGroup;

public interface ClarityGroupService {

    void save(ClarityGroup newGroup);
    
    Optional<ClarityGroup> searchById(Long id);
    
    Iterable<ClarityGroup> searchAll();
    
    List<ClarityGroup> searchAllActive();
    
    Integer updateStatus(Long id, Boolean status);
}