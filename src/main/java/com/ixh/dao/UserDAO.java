package com.ixh.dao;

import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.UserPO;

public interface UserDAO {

	UserPO save(UserPO userPO);

	UserPO find(String uid) throws DatabaseExceptionCO;

}
