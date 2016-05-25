package com.hsbc.dao;

import com.hsbc.pojo.CreditCard;

public class CreditCardDAO {

	public Boolean create(CreditCard cc){
		// Hibernate code
		System.out.println("CreditCardDAO()");
		return true;
	}
	
	public Boolean update(CreditCard cc){
		return true;
	}
	
	public Boolean delete(CreditCard cc){
		return true;
	}
}
