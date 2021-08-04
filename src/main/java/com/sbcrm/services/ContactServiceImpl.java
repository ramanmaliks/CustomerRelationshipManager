package com.sbcrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sbcrm.dao.UserRepository;
import com.sbcrm.entity.Cust;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Cust> getContacts() {
		System.out.println("USer Reposirtory"+ userRepository.findAll());
		return userRepository.findAll();
	}

	@Override
	public Cust addContact(Cust cust) {
		return userRepository.save(cust);
	}

	@Override
	public Cust updateContact(Cust cust, int custId) {
		Cust custNew = userRepository.getById(custId);
		custNew.setFname(cust.getFname());
		custNew.setLname(cust.getLname());
		custNew.setEmail(cust.getEmail());
		return userRepository.save(cust);
	}

	@Override
	public void deleteContact(int custId) {
		Cust custDel = userRepository.getById(custId);
		userRepository.delete(custDel);
	}

	
}
