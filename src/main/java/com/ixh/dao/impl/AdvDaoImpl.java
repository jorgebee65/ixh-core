package com.ixh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.AdvDao;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.AdvertiseBO;
import com.ixh.model.builder.Builders;
import com.ixh.model.po.AdvertisePO;


@Transactional
@Repository
public class AdvDaoImpl implements AdvDao {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdvertiseBO> getAllAdvertises() {
		List<AdvertiseBO> lstBO = new ArrayList<>();
		String hql = "FROM AdvertisePO";
		List<AdvertisePO> lstPO = (List<AdvertisePO>) entityManager.createQuery(hql).getResultList();
		if(lstPO!=null && !lstPO.isEmpty()) {
			lstBO = Builders.advBuilder.buildListBO(lstPO);
		}
		return lstBO;
	}
	
	@Override
	public AdvertiseBO find(Long id) throws DatabaseExceptionCO {
		AdvertiseBO bo = new AdvertiseBO();
		String hql = "FROM AdvertisePO where advId = :advID";
		try {
			Query query = entityManager.createQuery(hql);
			query.setParameter("advID", id);
			bo = Builders.advBuilder.buildBO((AdvertisePO) query.getSingleResult());
		} catch (NoResultException sre) {
			throw new DatabaseExceptionCO("Advertisement " + id + " not founded");
		}
		return bo;
	}
	
}
