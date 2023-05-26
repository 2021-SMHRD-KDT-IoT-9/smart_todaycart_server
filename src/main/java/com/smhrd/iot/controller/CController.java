package com.smhrd.iot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CController {
	
	@RequestMapping("myc")
	public ModelAndView c() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chatting");
		return mv;
	}

}
