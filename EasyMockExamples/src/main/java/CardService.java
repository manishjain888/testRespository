import com.hsbc.pojo.CreditCard;


public class CardService {

	private CreditCardService ccservice;
	private DebitCardService dcservice;
	
	public boolean create(CreditCard cc){		
		boolean ccflag = ccservice.create(cc);
		boolean dcflag1 = dcservice.create(cc);
		boolean dcflag2 = dcservice.delete(cc);
		return (ccflag && dcflag1 && dcflag2);		
	}
	
	public long count(){
		long count = dcservice.count() + dcservice.count1();
		return count;
	}
	
	public CreditCardService getCcservice() {
		return ccservice;
	}
	public void setCcservice(CreditCardService ccservice) {
		this.ccservice = ccservice;
	}
	public DebitCardService getDcservice() {
		return dcservice;
	}
	public void setDcservice(DebitCardService dcservice) {
		this.dcservice = dcservice;
	}
	
	public long count1(){
		return dcservice.count1();
	}
	
}
