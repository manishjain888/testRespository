package com.hmrc.codingtest.pricing;

import com.hmrc.codingtest.Basket;
import com.hmrc.codingtest.Discount;
import com.hmrc.codingtest.Item;
import com.hmrc.codingtest.rebates.Rebate;

import javax.annotation.Nonnull;

import static com.hmrc.codingtest.Discount.ZERO_DISCOUNT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountedBasketPricing extends ShoppingBasketPricingInterfaceImpl {

    @Override
    public BigDecimal price(Basket basket, Rebate... rebates) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        if( rebates != null ) {
            Discount optimalDiscount = optimalDiscount(basket, rebates);
            totalDiscount = optimalDiscount.getAmount();
        }
        BigDecimal amount =  price(basket);
        return amount.subtract(totalDiscount);
    }

    @Nonnull
    private Discount optimalDiscount(@Nonnull Basket basket, @Nonnull Rebate ... rebates) {
        Objects.requireNonNull(basket, "basket should not be empty");
        if(basket.getItems().isEmpty()){
            return ZERO_DISCOUNT;
        }

        List<Discount> discounts = new ArrayList<>();
        for(Rebate rebate: rebates){
            discounts.add(rebate.applyOnce(basket));
        }

        List<Discount> appliedDiscounts = discounts.stream().filter(d -> d.getAmount() != BigDecimal.ZERO).collect(Collectors.toList());

        List<Discount> candidates = new ArrayList<>();
        for(Discount discountSoFar: appliedDiscounts) {
          BigDecimal currentAmount = discountSoFar.getAmount();
          Basket itemsNotYetDiscounted = this.basketWithoutDiscountedItems(basket, discountSoFar.getDiscountedItems());

          Discount optimalDiscountOtherItems = optimalDiscount(itemsNotYetDiscounted , rebates);

          List<Item> discountedItems = new ArrayList<>();
          discountedItems.addAll(discountSoFar.getDiscountedItems());
          discountedItems.addAll(optimalDiscountOtherItems.getDiscountedItems());

          candidates.add( new Discount(currentAmount.add( optimalDiscountOtherItems.getAmount()), discountedItems) );
        }
        Optional<Discount> optimal = candidates.stream().max((a, b) -> a.getAmount().compareTo(b.getAmount()));

        if( optimal.isPresent() ) {
           return optimal.get();
        }
        return ZERO_DISCOUNT;
    }



}
