package com.ixh.dao;

import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.UserBO;
import com.ixh.model.po.UserPO;

public interface UserDAO {

	UserPO save(UserPO userPO);

	UserBO find(String uid) throws DatabaseExceptionCO;

}
