package com.ixh.model.bo;

public class AdvertiseBO extends BaseBO {
	private String title;
	private String image;
	//ToString values
	private String sPrice;
	private String sDiscount;
	private String sOriginalPrice;
	private CategoryBO category;
	
	//Details
	private String phone; 
	private String email;
	private String facebook;
	private String instagram;
	private String web;
	private Double latitude;
	private Double longitude;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getsPrice() {
		return sPrice;
	}
	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}
	public String getsDiscount() {
		return sDiscount;
	}
	public void setsDiscount(String sDiscount) {
		this.sDiscount = sDiscount;
	}
	public String getsOriginalPrice() {
		return sOriginalPrice;
	}
	public void setsOriginalPrice(String sOriginalPrice) {
		this.sOriginalPrice = sOriginalPrice;
	}
	public CategoryBO getCategory() {
		return category;
	}
	public void setCategory(CategoryBO category) {
		this.category = category;
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
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
