package com.ixh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	private CuponService srvCupon;
	
	@Autowired
	private NotificationService srvNotification;
	
	@RequestMapping(value = "/cupons", method = RequestMethod.POST)
	ResponseEntity<?> save(@RequestBody CuponBO cupon, UriComponentsBuilder ucBuilder) {
		CuponBO saved = srvCupon.generateCupon(cupon);
		srvNotification.sendNotification(saved);
		return new ResponseEntity<CuponBO>(saved,HttpStatus.OK);
	}
}
