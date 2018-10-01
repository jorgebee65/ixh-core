package com.ixh.dao;

import java.util.List;

import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;

public interface CuponDAO {

	List<CuponBO> getCupons(UserBO userBO) throws DatabaseExceptionCO;

	CuponBO save(CuponBO cuponBO);

	boolean checkAvailability(String pCup);

	CuponBO getCupon(String pCup) throws DatabaseExceptionCO;

}
