package com.sbcrm.services;

import java.util.List;

import com.sbcrm.entity.Cust;

public interface ContactService {
	
	public List<Cust> getContacts();
	
	public Cust addContact(Cust cust);
	// for updating a record
	public Cust updateContact(Cust cust, int custId);
	// for deleting a record
	public void deleteContact(int custId); 

}
