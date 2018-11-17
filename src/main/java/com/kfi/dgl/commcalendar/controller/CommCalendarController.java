package com.kfi.dgl.commcalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "CommCalendarController")
public class CommCalendarController {
	
	@RequestMapping(value="/community/commcalendar", method = RequestMethod.GET)
	public String commcalendar() {
		
		return ".community.commcalendar.calendar";
	}
	
}

