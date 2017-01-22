package com.hmrc.codingtest.rebates;

import javax.annotation.Nonnull;

import com.hmrc.codingtest.Item;

import static java.util.Objects.requireNonNull;


class RebateBuilderImpl implements RebateBuilder {

    @Nonnull
    public OfferBuilder on(int quantity, @Nonnull Item item) {
        requireNonNull(item, "Item should not be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity should be non negative");
        }
        return new OfferBuilderImpl(quantity, item);
    }

}
