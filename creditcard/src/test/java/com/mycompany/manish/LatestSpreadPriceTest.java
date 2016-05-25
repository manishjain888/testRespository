package com.mycompany.manish;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatestSpreadPriceTest {

	/**
	 * Requirement
	 * 1. We have input of source, symbol, ask and bid
	 * 2. spread = bid -ask
	 * 3. we need to get the latest spread of every security symbol 
	 * 4. every symbol spread price can come from multiple sources. So bloomberg send (google, apple) and hsbc (google and microsoft)
	 * 5. all spread gets cleared each day
	 * 6. if same source send us the ask and bid price of same symbol again, that need to replaced with existing one, if ay
	 * 7. so if this is replaced, again check the lowest spread price and print it on request
	 * 8. At the start of the day, there are no security data, so there should not be any nullpointerexception
	 * 9.for source, there is a QuoteSource object containing listener, receiver and getName()
	 * 10. Write QuoteServiceImpl
	 */
	@Test
	public final void test() {
		fail("Not yet implemented");
	}

}
