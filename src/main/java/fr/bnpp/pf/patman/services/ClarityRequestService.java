package fr.bnpp.pf.patman.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.bnpp.pf.patman.model.entities.ClarityRequest;

public interface ClarityRequestService {

    void save(ClarityRequest clarityRequest);

    Optional<ClarityRequest> searchById(Long id);
    
    List<ClarityRequest> searchAll();

    List<ClarityRequest> searchAllActive();
    
    Integer updateStatus(Long id, Long adminId, Date newDate);

}