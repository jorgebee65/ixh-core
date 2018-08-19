package com.ixh.model.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Advertise")
public class AdvertisePO implements Serializable{

	private static final long serialVersionUID = -4760155372002430354L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="adv_id")
	private Long advId;
	private String title;
	private String description;
	private Float price;
	private Integer discount;
	private String image;
	public Long getAdvId() {
		return advId;
	}
	public void setAdvId(Long advId) {
		this.advId = advId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
