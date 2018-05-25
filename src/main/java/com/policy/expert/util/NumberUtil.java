package com.policy.expert.util;

import java.math.BigDecimal;

public class NumberUtil {

    public static Double roundDiscountAsDiscount(final Double value) {
        return new BigDecimal(value > 0 ? -value : value).setScale(2, BigDecimal.ROUND_UP).doubleValue();
    }

    public static Double roundNumber(final Double value) {
        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
