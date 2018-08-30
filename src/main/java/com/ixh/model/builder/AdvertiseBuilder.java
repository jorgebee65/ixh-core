package com.ixh.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.ixh.model.bo.AdvertiseBO;
import com.ixh.model.po.AdvDetailsPO;
import com.ixh.model.po.AdvertisePO;
import com.ixh.util.AppFormatter;

public class AdvertiseBuilder implements Builder<AdvertiseBO, AdvertisePO> {
	
	@Override
	public AdvertiseBO buildBO(AdvertisePO po) {
		AdvertiseBO bo = new AdvertiseBO();
		  bo.setId(po.getAdvId());
		  bo.setDescription(po.getDescription());
		  bo.setImage(po.getImage());
		  bo.setsDiscount(po.getDiscount()+"%");
		  bo.setsPrice(AppFormatter.toCurrencyTx(po.getPrice()));
		  bo.setTitle(po.getTitle());
		  Float originalPrice = ((po.getPrice()*100)/(float)(100-po.getDiscount()));
		  bo.setsOriginalPrice(AppFormatter.toCurrencyTx(originalPrice));
		  bo.setCategory(Builders.catbuilder.buildBO(po.getCategory()));
		  bo.setStart(po.getStart());
		  bo.setEnds(po.getEnds());
		return bo;
	}

	@Override
	public AdvertisePO buildPO(AdvertiseBO bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertiseBO> buildListBO(List<AdvertisePO> lpos) {
		List<AdvertiseBO> lstBO = new ArrayList<>();
		lpos.forEach(po->{
			lstBO.add(buildBO(po));
			});
		return lstBO;
	}

	@Override
	public List<AdvertisePO> buildListPO(List<AdvertiseBO> lpos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public AdvertiseBO buildFullBO(AdvDetailsPO po) {
		AdvertiseBO bo = buildBO(po.getAdvPO());
		bo.setPhone(po.getPhone());
		bo.setEmail(po.getEmail());
		bo.setFacebook(po.getFacebook());
		bo.setInstagram(po.getInstagram());
		bo.setWeb(po.getWeb());
		bo.setLatitude(po.getLatitude());
		bo.setLongitude(po.getLongitude());
		return bo;
	}

}
