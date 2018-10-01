package com.ixh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ixh.model.bo.CuponBO;
import com.ixh.service.CuponService;
import com.ixh.service.NotificationService;

@Controller
@RequestMapping("/ixh")
public class CuponController {
	
	Logger logger = LoggerFactory.getLogger(CuponController.class);
	
	@Autowired
	private CuponService srvCupon;
	
	@Autowired
	private NotificationService srvNotification;
	
	@RequestMapping(value = "/cupons", method = RequestMethod.POST)
	ResponseEntity<?> save(@RequestBody CuponBO cupon, UriComponentsBuilder ucBuilder) {
		CuponBO saved = srvCupon.generateCupon(cupon);
		//srvNotification.sendNotification(saved);
		return new ResponseEntity<CuponBO>(saved,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cupons/{cuponid}", method = RequestMethod.GET)
	public void getFile(
	    @PathVariable("cuponid") String fileName, 
	    HttpServletResponse response) throws Exception {
	    	File initialFile = srvCupon.generateFile(fileName);
	        InputStream is = new FileInputStream(initialFile);
	      // copy it to response's OutputStream
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();

	}
}
