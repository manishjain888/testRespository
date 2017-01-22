package com.hmrc.codingtest.rebates;


import javax.annotation.Nonnull;

import com.hmrc.codingtest.Item;

import java.util.Objects;

public final class Rebates {

    private Rebates() {
    }

    // Popular discounts
    @Nonnull
    public static Rebate buyOneGetOneFree(@Nonnull Item item) {
        Objects.requireNonNull(item, "Item should not be null");
        return on(1, item).offer(1, item).free();
    }

    @Nonnull
    public static Rebate buyOneGetOneHalfPrice(@Nonnull Item item) {
        Objects.requireNonNull(item, "Item should not be null");
        return on(1, item).offer(1, item).discountedBy(50);
    }

    @Nonnull
    public static Rebate buyTwoGetOneFree(@Nonnull Item item) {
        Objects.requireNonNull(item, "Item should not be null");
        return on(2, item).offer(1, item).free();
    }


    public static OfferBuilder on(int quantity, @Nonnull Item item){
       return new RebateBuilderImpl().on(quantity, item);
    }



}
