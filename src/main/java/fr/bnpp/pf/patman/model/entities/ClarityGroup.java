package fr.bnpp.pf.patman.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ASSIGNMENT_GROUP")
public class ClarityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "SP_ID")
    private String sousprojetId;

    @Column(name = "LABEL")
    private String label;
    
    @Column(name = "SERVICE")
    private String service;

    @Column(name = "IS_ACTIVE")
    private Boolean status;

    @JsonIgnore    
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClarityRequest> requests = new ArrayList<ClarityRequest>();

    public ClarityGroup() {
    }

    public ClarityGroup(String sousprojetId, String label, String service, Boolean status,
            List<ClarityRequest> requests) {
        this.sousprojetId = sousprojetId;
        this.label = label;
        this.service = service;
        this.status = status;
        this.requests = requests;
    }

    public String getSousprojetId() {
        return sousprojetId;
    }

    public void setSousprojetId(String sousprojetId) {
        this.sousprojetId = sousprojetId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ClarityRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<ClarityRequest> requests) {
        this.requests = requests;
    }

    public Long getId() {
        return id;
    }



    
}