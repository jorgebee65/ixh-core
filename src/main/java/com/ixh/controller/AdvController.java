package com.ixh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ixh.dao.AdvDao;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.AdvertiseBO;

@Controller
@RequestMapping("/ixh")
public class AdvController {
	
	@Autowired
	private AdvDao advDAO;
	
	@RequestMapping(value="/advs",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAdvertisements() {
		List<AdvertiseBO> list = advDAO.getAllAdvertises();
		return new ResponseEntity<List<AdvertiseBO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/advs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdvertiseBO> getAdvertise(@PathVariable("id") long id) throws DatabaseExceptionCO {
		AdvertiseBO po = advDAO.find(id);
		return new ResponseEntity<AdvertiseBO>(po, HttpStatus.OK);
	}
	
	@RequestMapping(value="/advs/category/{id}",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAdvsByCat(@PathVariable("id") long id) {
		List<AdvertiseBO> list = advDAO.getAdvsByCategory(id);
		return new ResponseEntity<List<AdvertiseBO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/advs/scategory/{scat}",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAdvsByCat(@PathVariable("scat") String sParam) {
		List<AdvertiseBO> list = advDAO.getAdvsByStrCategory(sParam);
		return new ResponseEntity<List<AdvertiseBO>>(list,HttpStatus.OK);
	}

}
