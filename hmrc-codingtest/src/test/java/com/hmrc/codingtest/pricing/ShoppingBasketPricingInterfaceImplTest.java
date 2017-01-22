package com.hmrc.codingtest.pricing;

import org.junit.Test;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Item;
import com.hmrc.codingtest.pricing.ShoppingBasketPricingInterface;
import com.hmrc.codingtest.pricing.ShoppingBasketPricingInterfaceImpl;

import java.math.BigDecimal;
import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;
import static com.hmrc.codingtest.Item.*;
import static com.hmrc.codingtest.rebates.Rebates.buyOneGetOneFree;
import static com.hmrc.codingtest.rebates.Rebates.buyOneGetOneHalfPrice;
import static com.hmrc.codingtest.rebates.Rebates.buyTwoGetOneFree;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ShoppingBasketPricingInterfaceImplTest {


    @Test(expected = NullPointerException.class)
    public void priceNullBasket(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(Collections.<Item>emptyList());

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(null);

        fail("Should not come here. Null element must throw exception");
    }

    @Test
    public void priceEmptyBasket(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(Collections.<Item>emptyList());

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b);

        assertThat(BigDecimal.ZERO, is(result));
     }

    @Test
    public void basketPricedCorrectlyWithOneItem(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b);

        assertThat(BigDecimal.valueOf(0.60), is(result));
    }

    @Test
    public void basketPricedCorrectlyWithSomeItems(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple,Apple,Orange, Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b);

        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(3)).add(Orange.getPrice()), is(result));
    }

    @Test
    public void basketPricedCorrectlyWithSomeItemsAndBuyTwoGetOneFreeDiscount(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple,Apple,Orange, Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyTwoGetOneFree(Apple));

        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)).add(Orange.getPrice()), is(result));
    }


    @Test
    public void basketPricedCorrectlyWithSomeItemsAndBuyOneGetOneFreeDiscount(){
        Basket b = mock(Basket.class);
        when(b.getItems()).thenReturn(newArrayList(Apple,Apple,Apple, Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyOneGetOneFree(Apple));

        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)), is(result));
    }

    @Test
    public void basketPricedCorrectlyWithSomeItemsAndBuyOneGetOneFreeDiscountOnMultipleItems(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange,Apple,Apple,Apple, Apple, Orange));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyOneGetOneFree(Apple), buyOneGetOneFree(Orange));

        assertThat(Apple.getPrice().multiply(BigDecimal.valueOf(2)).add(Orange.getPrice()), is(result));
    }



    @Test
    public void basketPricedCorrectlyWithSomeItemsAndBuyTwoGetOneFreeDiscountOnMultipleItems(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange,Apple,Apple,Apple, Apple, Orange, Orange));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyTwoGetOneFree(Apple), buyTwoGetOneFree(Orange));

        BigDecimal toPay = BigDecimal.ZERO;
        // 3 for 2 Apple
        toPay = toPay.add(Apple.getPrice());
        toPay = toPay.add(Apple.getPrice());
        // No offer Apple
        toPay = toPay.add(Apple.getPrice());
        // 3 for 2 Orange
        toPay = toPay.add(Orange.getPrice());
        toPay = toPay.add(Orange.getPrice());

        assertThat(toPay, is(result));
    }


    @Test
    public void orderOfDiscountsDoesNotAffectFinalReduction(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange, Apple, Apple, Apple, Apple, Orange, Orange));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result1  = pricer.price(b, buyTwoGetOneFree(Apple), buyTwoGetOneFree(Orange));

        BigDecimal result2  = pricer.price(b, buyTwoGetOneFree(Orange), buyTwoGetOneFree(Apple) );

        assertEquals( result1, result2);
    }

    @Test
    public void priceCalculatedCorrectlyDifferentRebatesOnDifferentItems(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange, Apple, Apple, Apple, Orange ));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result1  = pricer.price(b, buyTwoGetOneFree(Apple), buyTwoGetOneFree(Orange));

        BigDecimal result2  = pricer.price(b, buyTwoGetOneFree(Orange),buyTwoGetOneFree(Apple) );

        assertEquals( result1, result2);
    }


    @Test
    public void priceCalculatedCorrectlyWhenNoEligibleItemsForDiscount(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList( Apple, Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result1  = pricer.price(b, buyOneGetOneFree(Orange));

        assertThat( Apple.getPrice().add(Apple.getPrice()), is(result1));
    }

    @Test
    public void priceCalculatedCorrectlyWithBuyOneGetOneHalfPriceDiscount(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange, Orange));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyOneGetOneHalfPrice(Orange));

        assertThat( Orange.getPrice().multiply(BigDecimal.valueOf(1.5)), is(result));
    }

    @Test
    public void priceCalculatedCorrectlyForBOGOFAndBuyOneGetOneHalfPrice(){
        Basket b = mock(Basket.class);
        when(b.getItems())
                .thenReturn(newArrayList(Orange, Orange, Apple, Apple));

        ShoppingBasketPricingInterface pricer = new ShoppingBasketPricingInterfaceImpl();
        BigDecimal result  = pricer.price(b, buyOneGetOneFree(Apple) , buyOneGetOneHalfPrice(Orange));

        BigDecimal expected = Orange.getPrice().multiply(BigDecimal.valueOf(1.5));
        expected = expected.add(Apple.getPrice());
        assertThat(expected, is(result));
    }




}
