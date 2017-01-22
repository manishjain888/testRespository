package com.hmrc.codingtest.rebates;

import org.junit.Test;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Discount;
import com.hmrc.codingtest.Item;
import com.hmrc.codingtest.rebates.Rebate;

import java.math.BigDecimal;
import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;
import static com.hmrc.codingtest.Item.*;
import static com.hmrc.codingtest.rebates.Rebates.buyOneGetOneFree;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuyOneGetOneFreeTest {

    @Test
    public void noDiscountOnEmptyBasket(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(Collections.<Item>emptyList());
        Rebate rebate = buyOneGetOneFree(Apple);

        Discount d = rebate.applyOnce(b);

        assertThat(BigDecimal.ZERO, is(d.getAmount()));
        assertThat(Collections.EMPTY_LIST, is(d.getDiscountedItems()));

    }

    @Test
    public void discountAppliedOnceForBasketWithEligibleItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple));
        Rebate rebate = buyOneGetOneFree(Apple);

        Discount d = rebate.applyOnce(b);


        assertThat(Apple.getPrice(), is(d.getAmount()));
        assertThat( d.getDiscountedItems(), hasItem(Apple));
        assertThat( 2, is(d.getDiscountedItems().size()) );
    }

    @Test
    public void noDiscountAppliedOnceForBasketWithoutEligibleItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Orange));
        Rebate rebate = buyOneGetOneFree(Apple);

        Discount d = rebate.applyOnce(b);

        assertThat(BigDecimal.ZERO, is(d.getAmount()));
        assertThat( 0, is( d.getDiscountedItems().size()) );
    }


    @Test
    public void discountAppliedForBasketWithMultipleItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Orange, Apple, Apple));
        Rebate rebate = buyOneGetOneFree(Apple);

        Discount d = rebate.applyOnce(b);

        assertThat(Apple.getPrice(), is(d.getAmount()));
        assertThat(d.getDiscountedItems(), hasItem(Apple));
        assertThat(2, is(d.getDiscountedItems().size()) );
    }

}
