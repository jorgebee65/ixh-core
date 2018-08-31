package com.ixh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.CuponDAO;
import com.ixh.model.po.CuponPO;
import com.ixh.model.po.UserPO;

@Transactional
@Repository
public class CuponDAOImpl implements CuponDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public CuponPO save(CuponPO cuponPO) {
		entityManager.getTransaction().begin();
		UserPO usr = entityManager.find(UserPO.class, cuponPO.getUserPO().getId());
		cuponPO.setUserPO(usr);
		entityManager.persist(cuponPO);
		entityManager.flush();
		entityManager.getTransaction().commit();
		return cuponPO;
	}

}
