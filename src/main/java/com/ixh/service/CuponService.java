package com.ixh.service;

import org.hibernate.service.spi.ServiceException;

import com.ixh.model.bo.CuponBO;

public interface CuponService {
	CuponBO generateCupon(CuponBO pCuponBO) throws ServiceException;
}
