package fr.bnpp.pf.patman.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bnpp.pf.patman.model.entities.ClarityContributor;
import fr.bnpp.pf.patman.model.entities.ClarityRequest;
import fr.bnpp.pf.patman.model.repositories.ClarityContributorRepository;

@Service
public class ClarityContributorServiceImpl implements ClarityContributorService {

    @Autowired
    private ClarityContributorRepository contributorRepository;

    //

    @Override
    public void save(ClarityContributor contributor) {
        contributorRepository.save(contributor);

    }

    @Override
    public void save(List<ClarityContributor> contributors) {
        contributorRepository.saveAll(contributors);

    }

    @Override
    public List<ClarityContributor> searchClarityContributors(ClarityRequest req) {
        List<Long> foundContibutorsId = new ArrayList<Long>();

        for (ClarityContributor c : new ArrayList<ClarityContributor>(req.getContributors()))
            foundContibutorsId.add(c.getId());
                
        return contributorRepository.findAllById(foundContibutorsId);
    }

}