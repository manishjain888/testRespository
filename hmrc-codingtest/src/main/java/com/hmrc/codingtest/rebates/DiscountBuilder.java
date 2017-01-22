package com.hmrc.codingtest.rebates;

interface DiscountBuilder {

    Rebate free();
    /* percentage value => 50 is 50% */
    Rebate discountedBy(double percentage);
}
