package com.smhrd.iot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	@Autowired
	andProductService service;
	
	//@RequestMapping(value="/appShoping", method=RequestMethod.GET)
	//public ArrayList<product>
	
}
