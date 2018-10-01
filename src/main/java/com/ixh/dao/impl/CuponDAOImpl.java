package com.ixh.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.CuponDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.model.builder.Builders;
import com.ixh.model.po.AdvertisePO;
import com.ixh.model.po.CuponPO;
import com.ixh.model.po.UserPO;

@Transactional
@Repository
public class CuponDAOImpl implements CuponDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public CuponBO save(CuponBO cuponBO) {
		CuponPO cupon = new CuponPO();
		UserPO usrPO = entityManager.find(UserPO.class, cuponBO.getUser().getId());
		AdvertisePO advPO = entityManager.find(AdvertisePO.class, cuponBO.getAdv().getId());
		cupon.setUserPO(usrPO);
		cupon.setAdv(advPO);
		cupon.setCode(cuponBO.getCode());
		cupon.setCreationDate(new Date());
		cupon.setActive(true);
		entityManager.persist(cupon);
		entityManager.flush();
		return Builders.cuponBuilder.buildBO(cupon);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuponBO> getCupons(UserBO userBO) throws DatabaseExceptionCO{
		List<CuponBO> lst = new ArrayList<>();
			String hql = "FROM CuponPO where userPO.id = :id";
			try {
				Query query = entityManager.createQuery(hql);
				query.setParameter("id", userBO.getId());
				lst = Builders.cuponBuilder.buildListBO((List<CuponPO>)query.getResultList());
			} catch (NoResultException sre) {
				throw new DatabaseExceptionCO("No cupons for user");
			}
		return lst;
	}
	
	@Override
	public boolean checkAvailability(String pCup) {
		String hql = "FROM CuponPO where code = :cup ";
		try {
			Query query = entityManager.createQuery(hql);
			query.setParameter("cup", pCup);
			if((CuponPO)query.getSingleResult()!=null) {
				return true;
			}
		} catch (NoResultException sre) {
			return false;
		}
		return false;
	}
	
	@Override
	public CuponBO getCupon(String pCup) throws DatabaseExceptionCO{
			String hql = "FROM CuponPO where code = :code";
			try {
				Query query = entityManager.createQuery(hql);
				query.setParameter("code", pCup);
				return Builders.cuponBuilder.buildBO((CuponPO)query.getSingleResult());
			} catch (NoResultException sre) {
				throw new DatabaseExceptionCO("No cupon founded");
			}
	}

}
