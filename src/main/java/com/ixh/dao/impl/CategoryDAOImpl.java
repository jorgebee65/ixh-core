package com.ixh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ixh.dao.CategoryDAO;
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

}
