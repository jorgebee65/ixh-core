package com.ixh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.service.CuponService;
import com.ixh.service.NotificationService;
import com.ixh.service.UserService;

@Controller
@RequestMapping("/ixh")
public class CuponController {

	Logger logger = LoggerFactory.getLogger(CuponController.class);

	@Autowired
	private CuponService srvCupon;

	@Autowired
	private UserService srvUser;

	@Autowired
	private NotificationService srvNotification;

	@RequestMapping(value = "/cupons", method = RequestMethod.POST)
	ResponseEntity<?> save(@RequestBody CuponBO cupon, UriComponentsBuilder ucBuilder) {
		CuponBO saved = srvCupon.generateCupon(cupon);
		// srvNotification.sendNotification(saved);
		return new ResponseEntity<CuponBO>(saved, HttpStatus.OK);
	}

	@RequestMapping(value = "/cupons/{cuponid}", method = RequestMethod.GET)
	public void getCupon(@PathVariable("cuponid") String psCuponCode, HttpServletResponse response,
			@RequestHeader HttpHeaders headers) {
		String userId = headers.get("uid").get(0);
		if (userId != null && !"".equals(userId)) {
			logger.info("UID: " + userId);
			UserBO userBO = srvUser.getUser(userId);
			if (userBO != null) {
				logger.info("Usuario encontrado " + userBO.getDisplayName());
				File initialFile;
				try {
					initialFile = srvCupon.generateFile(psCuponCode, userBO);
					InputStream is = new FileInputStream(initialFile);
					// copy it to response's OutputStream
					org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
					response.flushBuffer();
				} catch (ServiceException se) {
					logger.error(se.getMessage(), se);
				} catch (FileNotFoundException e) {
					logger.error("No se encuentra el archivo",e);
				} catch (IOException e) {
					logger.error("Excepción de IO",e);
				} catch (Exception e) {
					logger.error("Excepción",e);
				} 
			}
		} else {
			throw new ServiceException("Debe estar logueado");
		}
	}
}
