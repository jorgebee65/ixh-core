package com.ixh.model.builder;

import java.util.List;

public interface Builder<BO,PO> {
	
	BO buildBO(PO po);
	PO buildPO(BO bo);
	List<BO> buildListBO(List<PO> lpos);
	List<PO> buildListPO(List<BO> lpos);
	
}
