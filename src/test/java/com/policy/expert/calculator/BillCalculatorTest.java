package com.policy.expert.calculator;

import com.policy.expert.calculator.impl.BillCalculatorImpl;
import com.policy.expert.model.Article;
import com.policy.expert.model.impl.ArticleImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCalculatorTest {

    private BillCalculator billCalculator = new BillCalculatorImpl();


    @Test
    public void validateBillCalculationIfOfferAndPriceAreSame() {
        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);

        final Double actual = billCalculator.calculateBill(Arrays.asList(articleBeansA, articleBeansB), -1d);
        assertThat(actual).isEqualTo(0d);
    }

    @Test
    public void validateBillCalculationIfOfferIsLoweThanPrice() {
        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);

        final Double actual = billCalculator.calculateBill(Arrays.asList(articleBeansA, articleBeansB), -0.5d);
        assertThat(actual).isEqualTo(0.5d);
    }

    @Test
    public void validateBillCalculationIfOfferIsZero() {

        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);

        final Double actual = billCalculator.calculateBill(Arrays.asList(articleBeansA), -0d);
        assertThat(actual).isEqualTo(0.5d);
    }
}