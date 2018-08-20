package com.ixh.model.builder;

import java.util.List;

import com.ixh.model.bo.CategoryBO;
import com.ixh.model.po.CategoryPO;

public class CategoryBuilder implements Builder<CategoryBO, CategoryPO> {

	@Override
	public CategoryBO buildBO(CategoryPO po) {
		CategoryBO categoryBO= new CategoryBO();
		categoryBO.setId(po.getCatId());
		categoryBO.setDescription(po.getDescription());
		categoryBO.setIcon(po.getIcon());
		return categoryBO;
	}

	@Override
	public CategoryPO buildPO(CategoryBO bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryBO> buildListBO(List<CategoryPO> lpos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryPO> buildListPO(List<CategoryBO> lpos) {
		// TODO Auto-generated method stub
		return null;
	}

}
