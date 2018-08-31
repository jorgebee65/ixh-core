package com.ixh.model.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_app")
public class UserPO implements Serializable{
	
	private static final long serialVersionUID = 6173413478161144697L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(unique=true)
	private String uid;
	
	private String email;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="photo_url")
	private String photoURL;
	
	@OneToMany(mappedBy = "userPO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE })
	private List<CuponPO> cupons;
	
	public UserPO() {
		super();
	}

	public UserPO(Long id, String uid, String email, String displayName, String photoURL) {
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

	public List<CuponPO> getCupons() {
		if(cupons==null){
			cupons = new ArrayList<CuponPO>();
		}
		return this.cupons;
	}

	public void setCupons(List<CuponPO> cupons) {
		this.cupons = cupons;
	}

	public void addCupon(CuponPO cupon){
		if(cupons==null){
			cupons = new ArrayList<CuponPO>();
		}
		if(cupon.getUserPO()==null || !cupon.getUserPO().equals(this)){
			cupon.setUserPO(this);
		}
		cupons.add(cupon);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPO other = (UserPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
