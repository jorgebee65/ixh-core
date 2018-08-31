package com.ixh.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.model.po.CuponPO;
import com.ixh.model.po.UserPO;

public class CuponBuilder implements Builder<CuponBO, CuponPO>{

	@Override
	public CuponBO buildBO(CuponPO po) {
		CuponBO cupon = new CuponBO();
			cupon.setId(po.getId());
			cupon.setCode(po.getCode());
			cupon.setUser(new UserBO(po.getUserPO().getId(), po.getUserPO().getUid(), po.getUserPO().getEmail(), po.getUserPO().getDisplayName(), po.getUserPO().getPhotoURL()));
		return cupon;
	}

	@Override
	public CuponPO buildPO(CuponBO bo) {
		CuponPO cupon = new CuponPO();
			cupon.setId(bo.getId());
			cupon.setCode(bo.getCode());
			cupon.setUserPO(new UserPO(bo.getUser().getId(), bo.getUser().getUid(), bo.getUser().getEmail(), bo.getUser().getDisplayName(), bo.getUser().getPhotoURL()));
		return cupon;
	}

	@Override
	public List<CuponBO> buildListBO(List<CuponPO> lpos) {
		List<CuponBO> lstBO = new ArrayList<>();
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
