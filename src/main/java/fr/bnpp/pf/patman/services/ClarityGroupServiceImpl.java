package fr.bnpp.pf.patman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bnpp.pf.patman.model.entities.ClarityGroup;
import fr.bnpp.pf.patman.model.repositories.ClarityGroupRepository;

@Service
public class ClarityGroupServiceImpl implements ClarityGroupService{

    @Autowired
    private ClarityGroupRepository clarityGroupRepository;
    
    // Save a new groupList Item in repository
    @Override
    public void save(ClarityGroup newGroup) {
        clarityGroupRepository.save(newGroup);
    }

    // search a groupList Item in repository 
    @Override
    public Optional<ClarityGroup> searchById(Long id) {
        return clarityGroupRepository.findById(id);
        
    }
    
    // search and list all groupList Items in repository
    @Override
    public Iterable<ClarityGroup> searchAll() {
        return clarityGroupRepository.findAll();     
    }

    // search and list only active groupList Items in repository
    @Override
    public List<ClarityGroup> searchAllActive() {
        return clarityGroupRepository.findAllActive();   
    }
    
    // save a new status(boolean) for a groupList Item in repository
    // Specific method to implement in Repository 
    @Override
    public Integer updateStatus(Long id, Boolean status) {
        Integer result = clarityGroupRepository.updateStatus(id, status);
        return result;
        
    }
}