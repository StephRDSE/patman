package fr.bnpp.pf.patman.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bnpp.pf.patman.model.entities.ClarityRequest;
import fr.bnpp.pf.patman.services.ClarityRequestServiceImpl;
//import io.swagger.annotations.Api;

@RequestMapping(value = "/clarity/request")
@RestController
//@Api("WebService ClarityRequest")
public class ClarityRequestController {

    @Autowired
    private ClarityRequestServiceImpl clarityRequestService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ClarityRequest test) {
        
        
        
        return "La demande " + "a été correctement créée.";
    }
    
}