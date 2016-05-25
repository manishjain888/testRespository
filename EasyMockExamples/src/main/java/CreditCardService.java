

import com.hsbc.dao.CreditCardDAO;
import com.hsbc.pojo.CreditCard;

public class CreditCardService {

	private CreditCardDAO creditCardDAO;
	
	public Boolean create(CreditCard cc){
		System.out.println("Servie()");
		return creditCardDAO.create(cc);
	}
	
}
