package com.ixh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ixh.dao.CuponDAO;
import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.model.po.UserPO;

@Controller
@RequestMapping("/ixh")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CuponDAO cuponDAO;
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	ResponseEntity<?> save(@RequestBody UserPO user, UriComponentsBuilder ucBuilder) {
		UserPO saved = userDAO.save(user);
		return new ResponseEntity<UserPO>(saved,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserBO> getAdvertise(@PathVariable("uid") String uid) throws DatabaseExceptionCO {
		UserBO bo = userDAO.find(uid);
		return new ResponseEntity<UserBO>(bo, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}/cupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CuponBO>> getAdvertise(@PathVariable("id") long id) throws DatabaseExceptionCO {
		List<CuponBO> lstBOs = cuponDAO.getCupons(new UserBO(id));
		return new ResponseEntity<List<CuponBO>>(lstBOs, HttpStatus.OK);
	}

}
