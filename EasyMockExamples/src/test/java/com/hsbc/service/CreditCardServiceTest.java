
package com.hsbc.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hsbc.dao.CreditCardDAO;
import com.hsbc.pojo.CreditCard;

public class CreditCardServiceTest {

	private CreditCardService service = null;
	private CreditCardDAO dao = null;
	private CreditCard cc;
	
	@Before
	public void setup(){
		service = new CreditCardService();
		dao = createMock(CreditCardDAO.class);
		cc = createMock(CreditCard.class);
		service.setCreditCardDAO(dao);
	}
	
	@Test
	public void testCreate_TRUE(){
		expect(dao.create(cc)).andReturn(Boolean.TRUE);
	    replay(dao);
	    Boolean flag = service.create(cc);
		assertEquals(Boolean.TRUE, flag);
	}
	
	
	@Test
	public void testList(){
		
	    
		List list = createMock(List.class);		
		expect(list.add(1)).andReturn(Boolean.TRUE);
		expect(list.add(2)).andReturn(Boolean.TRUE);
		expect(list.add(3)).andReturn(Boolean.TRUE);
	    replay(list);
		
		list.add(1);
		list.add(2);
		list.add(3);
		//list.add(4);
		
		verify(list);
		
	}
	
	
	
	/*@Test
	public void testCreate_FALSE(){
		expect(dao.create(cc)).andReturn(Boolean.FALSE);
		 replay(dao);
		 
		Boolean flag = service.create(cc);
		// Verify mehtod output
		assertEquals(Boolean.FALSE, flag);
		
		verify(dao.create(cc));
		//verify(dao,times(1)).create(cc);
	}*/
	
	@After
	public void teardown(){
		service = null;
	}
}
