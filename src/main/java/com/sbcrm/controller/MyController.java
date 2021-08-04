package com.sbcrm.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbcrm.dao.UserRepository;
import com.sbcrm.entity.Cust;
import com.sbcrm.services.ContactService;

@Controller
public class MyController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model m) {
	
		List<Cust> cust = contactService.getContacts();
		m.addAttribute("Cust",cust);
		return "index";
	}
	
	@DeleteMapping("/d/{id}")
	public String contactdelete(@PathVariable("id") int id)
	{
		this.contactService.deleteContact(id);
		return "redirect:/";
	}
	
	@RequestMapping("/update/{id}")
	public String updateCust(@PathVariable("id") Integer id,Model m)
	{
		Cust cust = userRepository.getById(id);
		m.addAttribute("Cust",cust);
		System.out.println("Update " + cust);
		return "addcontact";
	}
	
	@PostMapping("/updated")
	public String updateCustDB(@Valid @ModelAttribute("Cust") Cust cust,
			BindingResult result,Principal principal, HttpSession session) {
	try {
	//	String name = principal.getName();
		System.out.println("NAME====>"+name);
		System.out.println("Updated====>"+cust);
		this.contactService.updateContact(cust, cust.getId());
//		this.contactService.updateContact(cust, cust.getId());
	return "redirect:/";
	} catch(Exception e)
	{
		System.out.println(result.getAllErrors());
		e.printStackTrace();
		
		return "redirect:/";
	}
	
	
	
	}
}
