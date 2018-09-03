package com.ixh.service.impl;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixh.dao.AdvDAO;
import com.ixh.dao.CuponDAO;
import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.AdvertiseBO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.service.CuponService;
import com.ixh.util.RandomString;

@Service
public class CuponServiceImpl implements CuponService {
	
	@Autowired
	private CuponDAO cuponDAO;
	
	@Autowired
	private AdvDAO advDAO;
	
	@Autowired
	private UserDAO usrDAO;
	
	@Override
	public CuponBO generateCupon(CuponBO pCuponBO) throws ServiceException {
		CuponBO resp = new CuponBO();
		AdvertiseBO adv = null;
		UserBO usrBO = null;
			try {
				adv = advDAO.find(pCuponBO.getAdv().getId());
				usrBO = usrDAO.find(pCuponBO.getUser().getUid());
			} catch (DatabaseExceptionCO e) {
				e.printStackTrace();
			}
		Date today = new Date();
		if(today.after(adv.getStart()) && today.before(adv.getEnds()) ) {
			resp.setCode(generateCode());
			resp.setAdv(adv);
			resp.setUser(usrBO);
		}else {
			throw new ServiceException("La vigencia del cupón ha caducado.");
		}
		return cuponDAO.save(resp);
	}
	
	private String generateCode() {
		String code = "";
		RandomString gen = new RandomString(5, ThreadLocalRandom.current());
		code = gen.nextString().toUpperCase();
		if(cuponDAO.checkAvailability(code)) {
			code = generateCode();
		}
		return code;
	}
}
