
package com.hsbc.service;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hsbc.dao.CreditCardDAO;
import com.hsbc.pojo.CreditCard;

@RunWith(EasyMockRunner.class)
public class CreditCardServiceAnnotationsTest {

	@TestSubject
	CreditCardService service = new CreditCardService();
	
	@Mock
	CreditCardDAO dao;
	
	
	@Test
	public void testCreate_TRUE(){
		CreditCard cc = new CreditCard();
		expect(dao.create(cc)).andReturn(Boolean.TRUE);
	    replay(dao);
	    Boolean flag = service.create(cc);
		assertEquals(Boolean.TRUE, flag);
	}
	
}
