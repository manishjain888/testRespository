package com.hmrc.codingtest;

import java.math.BigDecimal;


public enum Item {
    Apple(BigDecimal.valueOf(0.6)),
    Orange(BigDecimal.valueOf(0.3));

    private BigDecimal price;

    Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
