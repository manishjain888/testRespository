import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hsbc.pojo.CreditCard;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.anyObject;

public class CardServiceTest {

	private CardService cardService;
	private CreditCardService ccservice;
	private DebitCardService dcservice;
	
	@Before
	public void init(){
		cardService = new CardService();
		ccservice = createMock(CreditCardService.class);
		dcservice = createMock(DebitCardService.class);
		cardService.setCcservice(ccservice);
		cardService.setDcservice(dcservice);
	}
	
	@Test
	public void testCreate_anyXXXMethods(){
		// Stubbing
		expect(ccservice.create((CreditCard)anyObject())).andReturn(true).times(1);
		replay(ccservice);
		expect(dcservice.delete((CreditCard)anyObject())).andReturn(true).times(1);
		expect(dcservice.create((CreditCard)anyObject())).andReturn(true).times(1);
		
		replay(dcservice);
		
		boolean flag = cardService.create((CreditCard)anyObject());
		
	    assertEquals(true, flag);
	    verify(ccservice);
	    verify(dcservice);
	}
	
	@Test
	public void testCreate_createMock(){
		CreditCard cc = new CreditCard();
		// Stubbing
		expect(ccservice.create(cc)).andReturn(true).times(1);
		replay(ccservice);//1. stubbing  2.record method call verification 3. record times
		expect(dcservice.delete(cc)).andReturn(true).times(1);
		expect(dcservice.create(cc)).andReturn(true).times(1);
		
		replay(dcservice);
		
		boolean flag = cardService.create(cc);
		
	    assertEquals(true, flag);
	    verify(ccservice);
	    verify(dcservice);
	}
	
	@Test
	public void testCreate_createStrictMock(){
		cardService = new CardService();
		ccservice = createStrictMock(CreditCardService.class);
		dcservice = createStrictMock(DebitCardService.class);
		cardService.setCcservice(ccservice);
		cardService.setDcservice(dcservice);
		CreditCard cc = new CreditCard();
		// Stubbing
		expect(ccservice.create(cc)).andReturn(true).times(1);
		replay(ccservice);//1. stubbing  2.record method call verification 3. record times
		expect(dcservice.create(cc)).andReturn(true).times(1);
		expect(dcservice.delete(cc)).andReturn(true).times(1);
		replay(dcservice);
		
		boolean flag = cardService.create(cc);
		
	    assertEquals(true, flag);
	    verify(ccservice);
	    verify(dcservice);
	}
	
	@Test
	public void testCreate_createNiceMock(){
		cardService = new CardService();
		dcservice = createNiceMock(DebitCardService.class);
		cardService.setDcservice(dcservice);

		expect(dcservice.count()).andReturn(1L).times(1);
		replay(dcservice);
		
		long count = cardService.count();
		
	    assertEquals(1, count);
	    
	    verify(dcservice);
	}
	
	@Test
	public void testCreate_createNiceMock_testException(){
		cardService = new CardService();
		dcservice = createNiceMock(DebitCardService.class);
		cardService.setDcservice(dcservice);

		expect(dcservice.count1()).andThrow(new RuntimeException());
		replay(dcservice);
		
		long count = cardService.count1();
		
	    assertEquals(1, count);
	    
	    verify(dcservice);
	}
	
	@After
	public void cleanup(){
		cardService = null;		
	}
}
