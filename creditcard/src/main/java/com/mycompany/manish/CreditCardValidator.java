package com.mycompany.manish;

import java.math.BigInteger;


/**
 * Story credit card number
-----------------------------

User input the credit card number, program should be able to validate the credit card using the Luhn algorithm and identiy the full account number
Luhn algorithn
 1.Starting from the rightmost digit (the check digit), moving left, double the value of every second digit.
  if the doubling is greater than 9, sum the digits
 2. Take the sum of all digits, if the sum multiple by 9 modulo 10 is equal to 0 then number is valid, append the 0 as last to make the full account number. Otherwise sum multiply by 9 modulo 10 result is appended at very last of number to generate the whole account number. which is x say a check digit
  So Algorithm is
  1. Compute the sum of the digits
  2. Take the units digits
  3. Subtract the unit digit from 10
  4. the result is the check digit, this will make the whole account number
  
 * @author DiamondJain
 *
 */
public class CreditCardValidator {


	public static int ValidateCardUsingLuhnAlgo(String card){
		BigInteger cardNumber = new BigInteger(card);
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
		
		int checkDigit = (10-sum%10);
		System.out.println("Check digit = "+(10-sum%10));

		return checkDigit;
	}
	
	/**
	 * Divide the number by 10, get the remainder, sum the remainder
	 * if sum is greater than 9, sum it again and 
	 * modulo that digit , if its 0, it is a check digit
	 * @param cardNumber
	 * @return
	 */
	private int creditCardV(BigInteger cardNumber){
		BigInteger[] resultAndRemainder;
		int sum=0,count=0;
		do{
			count++;
			resultAndRemainder  = cardNumber.divideAndRemainder(BigInteger.TEN);
			if(count%2==0){
				if(resultAndRemainder[1].intValue()*2>9){
					sum = sum + (resultAndRemainder[1].intValue()*2 %10)+1;
				}
				else
					sum =sum + resultAndRemainder[1].intValue()*2;
				}
				
			cardNumber = resultAndRemainder[0];
		}
		while(!cardNumber.equals(BigInteger.ZERO));
		int checkDigit = 10 -sum%10;
		return checkDigit;
	}
	
	
	
}
