package com.policy.expert.calculator.impl;

import com.policy.expert.calculator.BillCalculator;
import com.policy.expert.model.Article;
import com.policy.expert.util.NumberUtil;

import java.util.List;

public class BillCalculatorImpl implements BillCalculator {

    @Override
    public Double calculateBill(final List<Article> articles, final Double discount) {

        final Double sumPrices = articles.stream()
                .map(k -> k.getPrice())
                .reduce(0d, (x, y) -> x + y);

        return Math.abs(NumberUtil.roundDiscount(sumPrices - Math.abs(discount)));
    }
}
