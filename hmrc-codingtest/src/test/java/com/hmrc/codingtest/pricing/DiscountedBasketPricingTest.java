package com.hmrc.codingtest.pricing;

import org.junit.Test;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Item;
import com.hmrc.codingtest.pricing.ShoppingBasketPricingInterface;
import com.hmrc.codingtest.pricing.DiscountedBasketPricing;

import java.math.BigDecimal;
import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;
import static com.hmrc.codingtest.Item.*;
import static com.hmrc.codingtest.rebates.Rebates.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DiscountedBasketPricingTest {


    @Test(expected = NullPointerException.class)
    public void priceNullBasket(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(Collections.<Item>emptyList());

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(null);

        fail("Should not come here. Null element must throw exception");

    }

    @Test
    public void priceEmptyBasket(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(Collections.<Item>emptyList());

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b);

        assertThat(BigDecimal.ZERO, is(result));
     }

    @Test
    public void basketPricedCorrectlyWithOneItem(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b);

        assertThat(BigDecimal.valueOf(0.60), is(result));
    }

    @Test
    public void basketPricedCorrectlyWithSomeItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple,Apple,Orange, Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b);

        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(3)).add(Orange.getPrice()), is(result));
    }

    @Test
    public void bOGOFChosenOverBuyOneGetOneHalfPriceOnSameItemSinglePair(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b, buyOneGetOneFree(Apple), buyOneGetOneHalfPrice(Apple));

        assertThat(Apple.getPrice() , is(result));
    }


    @Test
    public void bOGOFChosenOverBuyOneGetOneHalfPriceOnSameItemMultiplePairs(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple, Apple, Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b, buyOneGetOneFree(Apple), buyOneGetOneHalfPrice(Apple));

        // BOGOF should be applied twice in preference to Buy One get One half price
        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)) , is(result));
    }


    @Test
    public void bOGOFChosenOverBuyTwoGetOneFree(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple, Apple, Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b, buyTwoGetOneFree(Apple), buyOneGetOneFree(Apple));

        // BOGOF should be applied twice in preference to Buy Two get One half price
        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)) , is(result));
    }


    @Test
    public void bOGOFChosenOverAllOtherRebate(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple, Apple, Apple));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b, buyTwoGetOneFree(Apple), buyOneGetOneHalfPrice(Apple),  buyOneGetOneFree(Apple));

        // BOGOF should be applied twice in preference to Buy Two get One half price
        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)) , is(result));
    }



    @Test
    public void basketPricedCorrectlyWithDifferentOffersOnDifferentItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple, Apple, Orange, Orange,Orange));

        ShoppingBasketPricingInterface pricer = new DiscountedBasketPricing();
        BigDecimal result  = pricer.price(b, buyTwoGetOneFree(Orange), // Applied
                                             buyOneGetOneHalfPrice(Apple), // Discarded
                                             buyOneGetOneFree(Apple)); // Applied

        // BOGOF should be applied to Apples and 50% discount on second item for Banana
        BigDecimal expected = Apple.getPrice();
        expected = expected.add( Orange.getPrice().multiply(BigDecimal.valueOf(2)) );

        assertThat(expected, is(result));
    }

}
