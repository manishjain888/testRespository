package com.hmrc.codingtest.rebates;

import javax.annotation.Nonnull;

import com.hmrc.codingtest.Item;

public interface RebateBuilder {
    OfferBuilder on(int quantity, @Nonnull Item item);
}
