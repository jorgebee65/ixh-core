package com.ixh.controller;

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

import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.UserPO;

@Controller
@RequestMapping("/ixh")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	ResponseEntity<?> save(@RequestBody UserPO user, UriComponentsBuilder ucBuilder) {
		UserPO saved = userDAO.save(user);
		return new ResponseEntity<UserPO>(saved,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserPO> getAdvertise(@PathVariable("uid") String uid) throws DatabaseExceptionCO {
		UserPO po = userDAO.find(uid);
		return new ResponseEntity<UserPO>(po, HttpStatus.OK);
	}


}
