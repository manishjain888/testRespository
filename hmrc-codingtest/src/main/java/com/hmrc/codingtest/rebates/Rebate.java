package com.hmrc.codingtest.rebates;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Discount;

public interface Rebate {
   Discount applyOnce(Basket b);
}
