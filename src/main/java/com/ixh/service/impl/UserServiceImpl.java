package com.ixh.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.UserBO;
import com.ixh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserBO getUser(String pUserId) throws ServiceException{
		try {
			return userDAO.find(pUserId);
		} catch (DatabaseExceptionCO e) {
			throw new ServiceException("Usuario no válido", e);
		}
	}
}
