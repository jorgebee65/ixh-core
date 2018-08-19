package com.ixh.dao;

import java.util.List;

import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.AdvertisePO;

public interface AdvDao {

	List<AdvertisePO> getAllAdvertises();

	AdvertisePO find(Long id) throws DatabaseExceptionCO;

}
