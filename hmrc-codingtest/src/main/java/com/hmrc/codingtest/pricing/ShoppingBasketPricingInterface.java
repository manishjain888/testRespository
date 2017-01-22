package com.hmrc.codingtest.pricing;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.rebates.Rebate;

import java.math.BigDecimal;


public interface ShoppingBasketPricingInterface {

    BigDecimal price(Basket b , Rebate...rebates);
}
