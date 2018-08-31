package com.ixh.model.bo;

import java.util.ArrayList;
import java.util.List;

public class UserBO {

private Long id;
	
	private String uid;
	
	private String email;
	
	private String displayName;
	
	private String photoURL;
	
	private List<CuponBO> cupons;
	
	public UserBO(Long id, String uid, String email, String displayName, String photoURL) {
		super();
		this.id = id;
		this.uid = uid;
		this.email = email;
		this.displayName = displayName;
		this.photoURL = photoURL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public List<CuponBO> getCupons() {
		if(cupons==null) {
			cupons = new ArrayList<>();
		}
		return cupons;
	}

	public void setCupons(List<CuponBO> cupons) {
		this.cupons = cupons;
	}
	
}
