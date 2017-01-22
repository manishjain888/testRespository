package com.hmrc.codingtest.rebates;

import com.hmrc.codingtest.Item;


interface OfferBuilder {
    DiscountBuilder offer(int quantity, Item item);
}
