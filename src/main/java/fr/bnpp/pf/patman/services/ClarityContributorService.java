package fr.bnpp.pf.patman.services;

import java.util.List;

import fr.bnpp.pf.patman.model.entities.ClarityContributor;
import fr.bnpp.pf.patman.model.entities.ClarityRequest;

public interface ClarityContributorService {

    void save(ClarityContributor contributor);
    
    void save(List<ClarityContributor> contributors);
    
    List<ClarityContributor> searchClarityContributors (ClarityRequest request);
    
}