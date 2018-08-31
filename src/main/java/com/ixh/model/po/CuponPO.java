package com.ixh.model.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cupon")
public class CuponPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1393631895577968820L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cupon_id")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	private UserPO userPO;
	
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserPO getUserPO() {
		return userPO;
	}

	public void setUserPO(UserPO userPO) {
		if(!userPO.getCupons().contains(this)){
			userPO.getCupons().add(this);
		}
		this.userPO = userPO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		CuponPO other = (CuponPO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
