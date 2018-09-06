package fr.bnpp.pf.patman.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.bnpp.pf.patman.model.entities.ClarityGroup;
import fr.bnpp.pf.patman.services.ClarityGroupServiceImpl;
//import io.swagger.annotations.Api;

@RequestMapping(value = "/clarity/group")
@RestController
//@Api("WebService ClarityGroup")
public class ClarityGroupController {

    @Autowired
    private ClarityGroupServiceImpl clarityGroupService;

    // private static final Logger LOGGER = LoggerFactory.getLogger(ClarityGroupController.class);

    // Mapping on /clarity/group/create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ClarityGroup newGroup) {
        
         // SearchAll and compare, if exist do nothing then return error
        Iterable<ClarityGroup> completeGroups = clarityGroupService.searchAll();
        for (ClarityGroup group : completeGroups) {
            if (group.getSousprojetId().equals(newGroup.getSousprojetId())) {
                return "Une erreur est survenue, vérifiez la saisie " + newGroup.getSousprojetId();
            }
        }
        
        clarityGroupService.save(newGroup);
        return "Le groupe " + newGroup.getLabel() + " a été correctement ajouté";
    }
    
    // Mapping on /clarity/group/displayAll
    @RequestMapping(value = "/displayAll", method = RequestMethod.GET)
    @ResponseBody
    public List<ClarityGroup> getAll() {
        List<ClarityGroup> completeList = new ArrayList<ClarityGroup>();
        for(ClarityGroup g : clarityGroupService.searchAll()){
            completeList.add(g);
        }
        
        return completeList;

    }

    // Mapping on /clarity/group/displayActive : To suppress
    // Méthod to use in controller ClarityRequest
    @RequestMapping(value = "/displayActive", method = RequestMethod.GET)
    @ResponseBody
    public List<ClarityGroup> getAllActive() {
        return clarityGroupService.searchAllActive();

    }
    
    // Mapping on /clarity/group/update
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGroupById(@RequestBody ClarityGroup clarityGroup) {

        // Verify if group exist then Update
        if (clarityGroupService.searchById(clarityGroup.getId()).isPresent() && 
                clarityGroupService.searchById(clarityGroup.getId()).get().getStatus() != clarityGroup.getStatus() ) {
            clarityGroupService.updateStatus(clarityGroup.getId(), clarityGroup.getStatus());
        }
    }
}