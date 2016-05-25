package com.mycompany.manish;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import javax.security.auth.login.CredentialException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Diamond Jain
 * 
 * 
User input the credit card number, program should be able to validate the credit card using the Luhn algorithm and 
identiy the full account number
Luhn algorithn
 1.Starting from the rightmost digit (the check digit), moving left, double the value of every second digit.
  if the doubling is greater than 9, sum the digits
 2. Take the sum of all digits, if the sum multiple by 9 modulo 10 is equal to 0 then number is valid, 
 append the 0 as last to make the full account number. Otherwise sum multiply by 9 modulo 10 result is 
 appended at very last of number to generate the whole account number. which is x say a check digit
  So Algorithm is
  1. Compute the sum of the digits
  2. Take the units digits
  3. Subtract the unit digit from 10
  4. the result is the check digit, this will make the whole account number
  
 *
 */
@RunWith(value = Parameterized.class)
public class CreditCardValidatorTest {
	
	private CreditCardValidator ccValidator ;
	
	@Before
	public void init(){
		ccValidator = new CreditCardValidator();
	}

	@Ignore
	public void testValidAccountNumber() {
		String ccNumber = "7992739871";
		BigInteger cardNumber = new BigInteger(ccNumber);
		BigInteger[] resultAndRemainder ;
		int sum =0,count=0 ;
		do
		{
			count++;
			resultAndRemainder = cardNumber.divideAndRemainder(BigInteger.TEN);
			cardNumber  = resultAndRemainder[0];
			if(!(count%2 ==0)){
				if(resultAndRemainder[1].intValue() * 2 > 9){
					sum  = sum+  ((resultAndRemainder[1].intValue()*2) % 10) +1;
				}
				else
					sum  = sum+  resultAndRemainder[1].intValue()*2;
		}
		else
			sum  = sum +  (resultAndRemainder[1].intValue());
		}while(!cardNumber.equals(BigInteger.ZERO));
		//System.out.println("Sum "+sum);
		//System.out.println("Check digit = "+(10-sum%10));

		
		
	}
	

	/**
	 * To Test the same test method using valid values and expected result, take two parameters
	 * one is input parameter and other is expected output for the valid values 
	 */
	
	private String cardNumber;
	private int checkdigit;
	
	 public CreditCardValidatorTest(int chkdigit, String cardNo) {
		 checkdigit= chkdigit;
		 cardNumber= cardNo;
 }

	 @Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][]{{3,"7992739871"}};
		return Arrays.asList(data);
	}
	
	@Test
	public void testParametersNumber() {
		int chk = 3;
		String ccNumber = "7992739871";
		assertEquals(3, ccValidator.ValidateCardUsingLuhnAlgo(ccNumber));
	}


}
