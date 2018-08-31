package com.ixh.model.builder;

import java.util.List;

import com.ixh.model.bo.UserBO;
import com.ixh.model.po.UserPO;

public class UserBuilder implements Builder<UserBO, UserPO>{

	@Override
	public UserBO buildBO(UserPO po) {
		UserBO userBO = new UserBO(po.getId(), po.getUid(), po.getEmail(), po.getDisplayName(), po.getPhotoURL());
		if(po.getCupons()!=null && !po.getCupons().isEmpty()) {
			userBO.getCupons().addAll(Builders.cuponBuilder.buildListBO( po.getCupons()));
		}
		return userBO;
	}

	@Override
	public UserPO buildPO(UserBO bo) {
		UserPO userPO = new UserPO(bo.getId(), bo.getUid(), bo.getEmail(), bo.getDisplayName(), bo.getPhotoURL());
		if(bo.getCupons()!=null && !bo.getCupons().isEmpty()) {
			userPO.getCupons().addAll(Builders.cuponBuilder.buildListPO(bo.getCupons()));
		}
		return userPO;
	}

	@Override
	public List<UserBO> buildListBO(List<UserPO> lpos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPO> buildListPO(List<UserBO> lpos) {
		// TODO Auto-generated method stub
		return null;
	}

}
