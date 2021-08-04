package com.sbcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbcrm.entity.Cust;
import com.sbcrm.services.ContactService;

@Controller
@CrossOrigin
public class MyController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/")
	public String home(Model m) {
	
		List<Cust> cust = contactService.getContacts();
		m.addAttribute("Cust",cust);
		return "index";
	}
	
	@DeleteMapping("/d/{id}")
	
	
}
