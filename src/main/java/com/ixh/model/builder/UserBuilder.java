package com.ixh.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.ixh.model.bo.UserBO;
import com.ixh.model.po.UserPO;

public class UserBuilder implements Builder<UserBO, UserPO>{

	@Override
	public UserBO buildBO(UserPO po) {
		UserBO userBO = new UserBO(po.getId(), po.getUid(), po.getEmail(), po.getDisplayName(), po.getPhotoURL());
		return userBO;
	}

	@Override
	public UserPO buildPO(UserBO bo) {
		UserPO userPO = new UserPO(bo.getId(), bo.getUid(), bo.getEmail(), bo.getDisplayName(), bo.getPhotoURL());
		return userPO;
	}

	@Override
	public List<UserBO> buildListBO(List<UserPO> lpos) {
		List<UserBO> lstBOs = new ArrayList<UserBO>();
		lpos.forEach(po -> {
			lstBOs.add(buildBO(po));
		});
		return lstBOs;
	}

	@Override
	public List<UserPO> buildListPO(List<UserBO> lbos) {
		List<UserPO> lstPOs = new ArrayList<>();
		lbos.forEach(bo ->{
			lstPOs.add(buildPO(bo));
		});
		return lstPOs;
	}

}
