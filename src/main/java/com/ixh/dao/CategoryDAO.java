package com.ixh.dao;

import java.util.List;

import com.ixh.model.bo.GroupAdvBO;
import com.ixh.model.po.CategoryPO;

public interface CategoryDAO {

	List<CategoryPO> getAllCategories();
	List<GroupAdvBO> getGroups();

}
