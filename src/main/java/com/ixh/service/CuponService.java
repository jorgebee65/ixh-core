package com.ixh.service;

import java.io.File;

import org.hibernate.service.spi.ServiceException;

import com.ixh.exception.ServiceExceptionCO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;

public interface CuponService {
	CuponBO generateCupon(CuponBO pCuponBO) throws ServiceExceptionCO;

	File generateFile(String cupon, UserBO pUserBO) throws Exception;
}
