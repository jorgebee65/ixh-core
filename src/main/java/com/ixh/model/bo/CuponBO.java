package com.ixh.model.bo;

public class CuponBO {

	private Long id;
	private String code;
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
	public UserBO getUser() {
		return user;
	}
	public void setUser(UserBO user) {
		this.user = user;
	}
	
}
