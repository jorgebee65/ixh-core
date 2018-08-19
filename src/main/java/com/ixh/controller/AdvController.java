package com.ixh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ixh.dao.AdvDao;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.po.AdvertisePO;

@Controller
@RequestMapping("/ixh")
public class AdvController {
	
	@Autowired
	private AdvDao advDAO;
	
	@CrossOrigin(origins = "http://ixhuatlancillo.com")
	@RequestMapping(value="/advs",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAdvertisements() {
		List<AdvertisePO> list = advDAO.getAllAdvertises();
		return new ResponseEntity<List<AdvertisePO>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://ixhuatlancillo.com")
	@RequestMapping(value = "/advs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdvertisePO> getTaqueria(@PathVariable("id") long id) throws DatabaseExceptionCO {
		AdvertisePO po = advDAO.find(id);
		return new ResponseEntity<AdvertisePO>(po, HttpStatus.OK);
	}

}
