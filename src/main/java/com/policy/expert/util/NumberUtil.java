package com.policy.expert.util;

import java.math.BigDecimal;

public class NumberUtil {

    public static Double roundDiscount(final Double value) {
        return new BigDecimal(value > 0 ? -value : value).setScale(2, BigDecimal.ROUND_UP).doubleValue();
    }
}
