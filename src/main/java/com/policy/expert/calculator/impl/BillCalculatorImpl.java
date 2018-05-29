package com.policy.expert.calculator.impl;

import com.policy.expert.calculator.BillCalculator;
import com.policy.expert.exceptions.ParamException;
import com.policy.expert.model.Article;
import com.policy.expert.util.NumberUtil;

import java.util.List;

public class BillCalculatorImpl implements BillCalculator {

    @Override
    public Double calculateBill(final List<Article> articles, final Double discount) {

        try {
            final Double sumPrices = sumArticlesPrices(articles);

            return NumberUtil.roundNumber(sumPrices - Math.abs(discount));
        } catch (final NullPointerException e) {
            throw new ParamException("Invalid input parameter", e);
        }
    }

    @Override
    public Double calculateSubTotal(final List<Article> articles) {


        return articles != null && !articles.isEmpty() ? sumArticlesPrices(articles) : 0d;

    }

    private Double sumArticlesPrices(final List<Article> articles) {
        return NumberUtil.roundNumber(articles.stream()
                .map(k -> k.getPrice())
                .reduce(0d, (x, y) -> x + y));
    }
}
