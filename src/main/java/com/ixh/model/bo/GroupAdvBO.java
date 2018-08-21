package com.ixh.model.bo;

public class GroupAdvBO {
	private String category;
	private Long count;
	private String icon;
	
	public GroupAdvBO(String category, Long count, String icon) {
		super();
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
}
