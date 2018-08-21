package com.ixh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ixh.dao.CategoryDAO;
import com.ixh.model.bo.GroupAdvBO;
import com.ixh.model.po.CategoryPO;

@Controller
@RequestMapping("/ixh")
public class CategoryController {
	
	
	@Autowired
	private CategoryDAO catDAO;
	
	@RequestMapping(value="/cats",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAdvertisements() {
		List<CategoryPO> list = catDAO.getAllCategories();
		return new ResponseEntity<List<CategoryPO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/groups",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getGroups(){
		List<GroupAdvBO> results = catDAO.getGroups();
		return new ResponseEntity<List<GroupAdvBO>>(results,HttpStatus.OK);
	}

}
