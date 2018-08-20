package com.ixh.model.bo;

public class AdvertiseBO extends BaseBO {
	private String title;
	private String image;
	//ToString values
	private String sPrice;
	private String sDiscount;
	private String sOriginalPrice;
	private CategoryBO category;
	
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
}
