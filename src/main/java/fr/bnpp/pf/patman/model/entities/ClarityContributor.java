package fr.bnpp.pf.patman.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLARITY_CONTRIBUTOR")
public class ClarityContributor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "UID", length = 6, nullable = true)
	private String uid;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "CHARGE_TIME")
	private Double charge;

	@ManyToOne
	@JoinColumn(name = "FK_CLARITYREQUEST_ID")
	private ClarityRequest request;

	public ClarityContributor() {

	}

	public ClarityContributor(Long id, String uid, String lastName, String firstName, Double charge,
			ClarityRequest request) {
		this.id = id;
		this.uid = uid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.charge = charge;
		this.request = request;

	}

	public Long getId() {
		return id;

	}

	public String getUid() {
		return uid;

	}

	public void setUid(String uid) {
		this.uid = uid;

	}

	public String getLastName() {
		return lastName;

	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public Double getCharge() {
		return charge;

	}

	public void setCharge(Double charge) {
		this.charge = charge;

	}

	public ClarityRequest getRequest() {
		return request;

	}

	public void setRequest(ClarityRequest request) {
		this.request = request;

	}

}
