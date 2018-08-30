package com.ixh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.UserPO;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public UserPO save(UserPO userPO) {
		entityManager.persist(userPO);
		entityManager.flush();
		return userPO;
	}
	
	@Override
	public UserPO find(String uid) throws DatabaseExceptionCO {
		UserPO user = null;
		String hql = "FROM UserPO where uid = :uid";
		try {
			Query query = entityManager.createQuery(hql);
			query.setParameter("uid", uid);
			user = (UserPO)query.getSingleResult();
		} catch (NoResultException sre) {
			throw new DatabaseExceptionCO("User " + uid + " not founded");
		}
		return user;
	}
}
