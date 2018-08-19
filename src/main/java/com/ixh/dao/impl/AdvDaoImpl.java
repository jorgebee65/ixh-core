package com.ixh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.AdvDao;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.AdvertisePO;


@Transactional
@Repository
public class AdvDaoImpl implements AdvDao {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdvertisePO> getAllAdvertises() {
		String hql = "FROM AdvertisePO";
		return (List<AdvertisePO>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public AdvertisePO find(Long id) throws DatabaseExceptionCO {
		AdvertisePO po = new AdvertisePO();
		String hql = "FROM AdvertisePO where advId = :advID";
		try {
			Query query = entityManager.createQuery(hql);
			query.setParameter("advID", id);
			po = (AdvertisePO) query.getSingleResult();
		} catch (NoResultException sre) {
			throw new DatabaseExceptionCO("Advertisement " + id + " not founded");
		}
		return po;
	}
	
}
