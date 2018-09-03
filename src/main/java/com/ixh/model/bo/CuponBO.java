package com.ixh.model.bo;

import java.util.Date;

public class CuponBO {

	private Long id;
	private String code;
	private Date creationDate;
	private boolean active;
	private AdvertiseBO adv;
	private UserBO user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public AdvertiseBO getAdv() {
		return adv;
	}
	public void setAdv(AdvertiseBO adv) {
		this.adv = adv;
	}
	public UserBO getUser() {
		return user;
	}
	public void setUser(UserBO user) {
		this.user = user;
	}

	
	
}
