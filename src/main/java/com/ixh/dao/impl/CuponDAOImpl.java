package com.ixh.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(CuponDAOImpl.class);
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public CuponBO save(CuponBO cuponBO) throws DatabaseExceptionCO{
		CuponPO cupon = new CuponPO();
		try {
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
		}catch(PersistenceException cv) {
			 Throwable t = cv.getCause();
			    while ((t != null) && !(t instanceof ConstraintViolationException)) {
			        t = t.getCause();
			    }
			    if (t instanceof ConstraintViolationException) {
			    	throw new DatabaseExceptionCO("El establecimiento solo permite un cupón por usuario",cv);
			    }
			    throw new DatabaseExceptionCO("Error al intentar asignar el cupon al usuario",cv);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			throw new DatabaseExceptionCO(e.getMessage(),e);
		}
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
	public CuponBO getCupon(String pCup, UserBO pUserBO) throws DatabaseExceptionCO{
			String hql = "FROM CuponPO where code = :code and userPO.id = :userID";
			try {
				Query query = entityManager.createQuery(hql);
				query.setParameter("code", pCup);
				query.setParameter("userID", pUserBO.getId());
				return Builders.cuponBuilder.buildBO((CuponPO)query.getSingleResult());
			} catch (NoResultException sre) {
				throw new DatabaseExceptionCO("No se encontró el cupón ["+pCup+"] para el usuario especificado");
			}
	}

}
