package com.ixh.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name="date_start")
	@Temporal(TemporalType.DATE)
	private Date start;
	@Column(name="date_end")
	@Temporal(TemporalType.DATE)
	private Date ends;
	
	@OneToOne(mappedBy = "advPO", cascade = CascadeType.ALL, 
    fetch = FetchType.LAZY, optional = false)
	private AdvDetailsPO details;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private CategoryPO category;
	
	
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
	public CategoryPO getCategory() {
		return category;
	}
	public void setCategory(CategoryPO category) {
		this.category = category;
	}
	
	public void setDetails(AdvDetailsPO details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setAdvPO(null);
            }
        }
        else {
            details.setAdvPO(this);
        }
        this.details = details;
    }
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnds() {
		return ends;
	}
	public void setEnds(Date ends) {
		this.ends = ends;
	}
}
