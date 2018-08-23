package com.ixh.model.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adv_details")
public class AdvDetailsPO {
	
	@Id
    private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId 
    private AdvertisePO advPO;
	
	private String phone;
	private String email;
	private String facebook;
	private String instagram;
	private String web;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdvertisePO getAdvPO() {
		return advPO;
	}

	public void setAdvPO(AdvertisePO advPO) {
		this.advPO = advPO;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

}
