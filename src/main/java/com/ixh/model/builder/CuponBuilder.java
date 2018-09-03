package com.ixh.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.ixh.model.bo.CuponBO;
import com.ixh.model.po.CuponPO;

public class CuponBuilder implements Builder<CuponBO, CuponPO>{

	@Override
	public CuponBO buildBO(CuponPO po) {
		CuponBO cupon = new CuponBO();
			cupon.setId(po.getId());
			cupon.setCode(po.getCode());
			cupon.setActive(po.isActive());
			cupon.setCreationDate(po.getCreationDate());
			if(po.getAdv()!=null)
			cupon.setAdv(Builders.advBuilder.buildBO(po.getAdv()));
		return cupon;
	}

	@Override
	public CuponPO buildPO(CuponBO bo) {
		CuponPO cupon = new CuponPO();
			cupon.setId(bo.getId());
			cupon.setCode(bo.getCode());
			cupon.setActive(bo.isActive());
			cupon.setCreationDate(bo.getCreationDate());
			cupon.setAdv(Builders.advBuilder.buildPO(bo.getAdv()));
		return cupon;
	}

	@Override
	public List<CuponBO> buildListBO(List<CuponPO> lpos) {
		List<CuponBO> lstBO = new ArrayList<>();
		if(lpos!=null && !lpos.isEmpty())
		lpos.forEach(po -> {
			lstBO.add(buildBO(po));
		});
		return lstBO;
	}

	@Override
	public List<CuponPO> buildListPO(List<CuponBO> lpos) {
		List<CuponPO> lstPO = new ArrayList<>();
		lpos.forEach(bo -> {
			lstPO.add(buildPO(bo));
		});
		return lstPO;
	}

}
