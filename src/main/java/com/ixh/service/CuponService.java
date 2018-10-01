package com.ixh.service;

import java.io.File;

import org.hibernate.service.spi.ServiceException;

import com.ixh.model.bo.CuponBO;

public interface CuponService {
	CuponBO generateCupon(CuponBO pCuponBO) throws ServiceException;

	File generateFile(String cupon) throws Exception;
}
