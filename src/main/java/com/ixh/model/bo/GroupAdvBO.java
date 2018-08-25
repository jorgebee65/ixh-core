package com.ixh.model.bo;

public class GroupAdvBO {
	private Long id;
	private String category;
	private Long count;
	private String icon;
	
	public GroupAdvBO(Long id, String category, Long count, String icon) {
		super();
		this.id = id;
		this.category = category;
		this.count = count;
		this.icon = icon;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
