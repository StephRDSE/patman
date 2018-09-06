package fr.bnpp.pf.patman.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bnpp.pf.patman.model.entities.ClarityRequest;
import fr.bnpp.pf.patman.model.repositories.ClarityRequestRepository;

@Service
public class ClarityRequestServiceImpl implements ClarityRequestService {

    @Autowired
    private ClarityRequestRepository requestRepository;

    // Save a new request in repository
    @Override
    public void save(ClarityRequest clarityRequest) {
        requestRepository.save(clarityRequest);
    }

    // search a request in repository with id
    @Override
    public Optional<ClarityRequest> searchById(Long id) {
        return requestRepository.findById(id);
    }
    
    // search and list all requests in repository
    @Override
    public List<ClarityRequest> searchAll() {
        return requestRepository.findAll();
    }

    // search and list all requests without statusUpdateDate and admin info in repository
    @Override
    public List<ClarityRequest> searchAllActive() {
        return requestRepository.findAllActive();
    }

    // save a new statusUpdateDate(date) and admin  values for a request in repository
    // Specific method to update in Repository by id
    @Override
    public Integer updateStatus(Long id, Long adminId, Date newDate) {
        return requestRepository.updateRequest(id, adminId, newDate);
    }

}

