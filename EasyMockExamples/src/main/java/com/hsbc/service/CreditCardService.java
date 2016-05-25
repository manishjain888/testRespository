
package com.hsbc.service;
import com.hsbc.dao.CreditCardDAO;
import com.hsbc.pojo.CreditCard;

public class CreditCardService {

	private CreditCardDAO creditCardDAO;
	
	public Boolean create(CreditCard cc){
		System.out.println("Servie()");
		return creditCardDAO.create(cc);
	}
	
	public Boolean update(CreditCard cc){
		return creditCardDAO.update(cc);
	}
	
	public Boolean delete(CreditCard cc){
		return creditCardDAO.delete(cc);
	}

	public CreditCardDAO getCreditCardDAO() {
		return creditCardDAO;
	}

	public void setCreditCardDAO(CreditCardDAO creditCardDAO) {
		this.creditCardDAO = creditCardDAO;
	}
}
