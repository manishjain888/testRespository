package com.hmrc.codingtest.pricing;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Discount;
import com.hmrc.codingtest.Item;
import com.hmrc.codingtest.rebates.Rebate;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingBasketPricingInterfaceImpl implements ShoppingBasketPricingInterface {

    @Nonnull
    protected BigDecimal price(@Nonnull Basket b) {
        Objects.requireNonNull(b , "Basket should not be null");

        if( b.getItems() == null ){
            return BigDecimal.ZERO;
        }

        BigDecimal result = BigDecimal.ZERO;
        for(Item i: b.getItems()){
            result = result.add(i.getPrice());
        }
        return result;
    }

    @Override
    public BigDecimal price(Basket basket, Rebate... rebates) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        if( rebates != null ) {
            for(Rebate rebate : rebates) {
                Basket currentBasket = basket;
                Discount discount = rebate.applyOnce(currentBasket);
                while (discount.getAmount() != BigDecimal.ZERO) {
                    totalDiscount = totalDiscount.add(discount.getAmount());
                    currentBasket = basketWithoutDiscountedItems(currentBasket , discount.getDiscountedItems());
                    discount = rebate.applyOnce(currentBasket);
                }
            }
        }
        BigDecimal amount =  price(basket);
        return amount.subtract(totalDiscount);
    }

    protected Basket basketWithoutDiscountedItems(Basket b , List<Item> discountedItems){
        Basket basketWithoutDiscountedItems = new Basket();
        List<Item> itemsInBasket =  new ArrayList<>(b.getItems());

        discountedItems.forEach(itemsInBasket::remove);
        itemsInBasket.forEach(basketWithoutDiscountedItems::addItem);

        return  basketWithoutDiscountedItems;
    }
}
