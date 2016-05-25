

import com.hsbc.dao.CreditCardDAO;
import com.hsbc.pojo.CreditCard;

public class DebitCardService {

	public long count;
	
	private CreditCardDAO creditCardDAO;
	
	public Boolean create(CreditCard cc){
		System.out.println("Servie()");
		return creditCardDAO.create(cc);
	}
	public Boolean delete(CreditCard cc){
		System.out.println("Servie()");
		return creditCardDAO.delete(cc);
	}
	
	public long count(){
		return count;
	}
	
	public long count1(){
		return count+1;
	}
}
