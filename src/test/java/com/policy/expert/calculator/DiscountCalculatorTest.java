package com.policy.expert.calculator;

import com.policy.expert.calculator.impl.DiscountCalculatorImpl;
import com.policy.expert.exceptions.ParamException;
import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.model.impl.ArticleImpl;
import com.policy.expert.model.impl.OfferImpl;
import com.policy.expert.types.OfferType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DiscountCalculatorTest {

    private DiscountCalculator discountCalculator = new DiscountCalculatorImpl();


    @Test
    public void calculateDiscountForQuantity() {
        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansC = new ArticleImpl("Beans", 0.50d);

        final Offer offerBeans = new OfferImpl();
        offerBeans.setArticleOfferedName("Beans");
        offerBeans.setOfferType(OfferType.UNITS);
        offerBeans.setOfferValueAforB(3, 2d);

        final Double actual = discountCalculator.calculateDiscount(Arrays.asList(articleBeansA, articleBeansB, articleBeansC), Arrays.asList(offerBeans));
        assertThat(actual).isEqualTo(-0.50);
    }

    @Test
    public void calculateDiscountForPrice() {
        final Article articleCokeA = new ArticleImpl("Coke", 0.70d);
        final Article articleCokeB = new ArticleImpl("Coke", 0.70d);

        final Offer offerCoke = new OfferImpl();
        offerCoke.setArticleOfferedName("Coke");
        offerCoke.setOfferType(OfferType.PRICE);
        offerCoke.setOfferValueAforB(2, 1d);

        final Double actual = discountCalculator.calculateDiscount(Arrays.asList(articleCokeA, articleCokeB), Arrays.asList(offerCoke));
        assertThat(actual).isEqualTo(-0.40);
    }


    @Test
    public void calculateDiscountForPriceAndQuantityAndArticle() {

        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansC = new ArticleImpl("Beans", 0.50d);

        final Offer offerBeans = new OfferImpl();
        offerBeans.setArticleOfferedName("Beans");
        offerBeans.setOfferType(OfferType.UNITS);
        offerBeans.setOfferValueAforB(3, 2d);


        final Article articleCokeA = new ArticleImpl("Coke", 0.70d);
        final Article articleCokeB = new ArticleImpl("Coke", 0.70d);

        final Offer offerCoke = new OfferImpl();
        offerCoke.setArticleOfferedName("Coke");
        offerCoke.setOfferType(OfferType.PRICE);
        offerCoke.setOfferValueAforB(2, 1d);


        final Double discountBeans = discountCalculator.calculateDiscountByArticle("Beans", Arrays.asList(articleBeansA, articleBeansB, articleBeansC), Arrays.asList(offerBeans));
        assertThat(discountBeans).isEqualTo(-0.50);

        final Double discountCokes = discountCalculator.calculateDiscountByArticle("Coke", Arrays.asList(articleCokeA, articleCokeB), Arrays.asList(offerCoke));
        assertThat(discountCokes).isEqualTo(-0.40);

        final Double actual = discountCalculator.calculateDiscount(Arrays.asList(articleCokeA, articleCokeB, articleBeansA, articleBeansB, articleBeansC), Arrays.asList(offerCoke, offerBeans));
        assertThat(actual).isEqualTo(-0.90);

    }

    @Test
    public void validateCalculateDiscountByArticleExceptionIsthrownOnNullList() {
        assertThatThrownBy( () -> discountCalculator.calculateDiscountByArticle("Beans", null, null))
                .isInstanceOf(ParamException.class)
                .hasMessage("Invalid input parameter");
    }

    @Test
    public void validateCalculateDiscountExceptionIsthrownOnNullList() {
        assertThatThrownBy( () -> discountCalculator.calculateDiscount(null, null))
                .isInstanceOf(ParamException.class)
                .hasMessage("Invalid input parameter");
    }
}