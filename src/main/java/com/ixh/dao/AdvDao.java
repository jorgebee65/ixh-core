package com.ixh.dao;

import java.util.List;

import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.AdvertiseBO;

public interface AdvDao {

	List<AdvertiseBO> getAllAdvertises();

	AdvertiseBO find(Long id) throws DatabaseExceptionCO;

}
