package com.ixh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.CategoryDAO;
import com.ixh.model.bo.GroupAdvBO;
import com.ixh.model.po.CategoryPO;

@Transactional
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryPO> getAllCategories() {
		String hql = "FROM CategoryPO";
		return (List<CategoryPO>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public List<GroupAdvBO> getGroups(){
		StringBuilder sb = new StringBuilder("SELECT new com.ixh.model.bo.GroupAdvBO(cat.catId, cat.description, count(cat.description), cat.icon) ");
		sb.append(" from AdvertisePO ad JOIN CategoryPO cat ");
		sb.append(" on cat.catId = ad.category.catId ");
		sb.append(" group by cat.description ");
		@SuppressWarnings("unchecked")
		List<GroupAdvBO> res = (List<GroupAdvBO>) entityManager.createQuery(sb.toString()).getResultList();
		return res;
	}

}
