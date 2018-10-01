package com.ixh.service;

import org.hibernate.service.spi.ServiceException;

import com.ixh.model.bo.UserBO;

public interface UserService {

	UserBO getUser(String pUserId) throws ServiceException;

}
