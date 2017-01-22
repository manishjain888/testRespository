package com.hmrc.codingtest;

import org.junit.Test;

import java.math.BigDecimal;

import static com.hmrc.codingtest.Item.Apple;
import static com.hmrc.codingtest.Item.Orange;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void itemsHaveCorrectPrice(){
        assertEquals(Apple.getPrice(), BigDecimal.valueOf(0.60));
        assertEquals(Orange.getPrice(), BigDecimal.valueOf(0.30));
    }



}
