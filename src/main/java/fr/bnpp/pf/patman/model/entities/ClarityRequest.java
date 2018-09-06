package fr.bnpp.pf.patman.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLARITY_REQUEST")
public class ClarityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DME_CODE")
    private String dmeCode;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "GLOBAL_CHARGE_TIME")
    private Double globalChargeTime;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "MEP_DATE")
    private Date mepDate;

    @ManyToOne
    @JoinColumn(name = "FK_ADMIN_ID")
    private User admin;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "STATUS_UPDATE_DATE")
    private Date statusUpdateDate;

    @ManyToOne
    @JoinColumn(name = "FK_ASSIGNMENT_GROUP_ID")
    private ClarityGroup group;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClarityContributor> contributors = new ArrayList<ClarityContributor>();

    @ManyToOne
    @JoinColumn(name = "FK_CREATOR_ID")
    private User creator;

    public ClarityRequest() {

    }

    public ClarityRequest(String dmeCode, String label, Double globalChargeTime, Date creationDate, Date mepDate,
            User admin, Date statusUpdateDate, ClarityGroup group, List<ClarityContributor> contributors,
            User creator) {
        super();
        this.dmeCode = dmeCode;
        this.label = label;
        this.globalChargeTime = globalChargeTime;
        this.creationDate = creationDate;
        this.mepDate = mepDate;
        this.admin = admin;
        this.statusUpdateDate = statusUpdateDate;
        this.group = group;
        this.contributors = contributors;
        this.creator = creator;
    }



    public String getDmeCode() {
        return dmeCode;
    }

    public void setDmeCode(String dmeCode) {
        this.dmeCode = dmeCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getGlobalChargeTime() {
        return globalChargeTime;
    }

    public void setGlobalChargeTime(Double globalChargeTime) {
        this.globalChargeTime = globalChargeTime;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getMepDate() {
        return mepDate;
    }

    public void setMepDate(Date mepDate) {
        this.mepDate = mepDate;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Date getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(Date statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    public ClarityGroup getGroup() {
        return group;
    }

    public void setGroup(ClarityGroup group) {
        this.group = group;
    }

    public List<ClarityContributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<ClarityContributor> contributors) {
        this.contributors = contributors;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClarityRequest [id=" + id + ", dmeCode=" + dmeCode + ", label=" + label + ", globalChargeTime="
                + globalChargeTime + ", creationDate=" + creationDate + ", mepDate=" + mepDate + ", admin=" + admin
                + ", statusUpdateDate=" + statusUpdateDate + ", group=" + group.getLabel() + ", contributors=" + contributors.size()
                + ", creator=" + creator + "]";
    }

    
}