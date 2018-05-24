package com.policy.expert;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.service.ShoppingBagService;
import com.policy.expert.types.OfferType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingJourneyTest {


    private ShoppingBagService shoppingBagService;


    @Test
    public void validateShoopingBasketReceipt() {

        final Offer offerBeans = null;
        final Offer offerCoke = null;

        final Article articleBeansA = null;
        final Article articleBeansB = null;
        final Article articleBeansC = null;
        final Article articleCokeA = null;
        final Article articleCokeB = null;
        final Article oranges = null;

        shoppingBagService.addArticleToShoppingBag(articleBeansA);
        shoppingBagService.addArticleToShoppingBag(articleBeansB);
        shoppingBagService.addArticleToShoppingBag(articleBeansC);
        shoppingBagService.addArticleToShoppingBag(articleCokeA);
        shoppingBagService.addArticleToShoppingBag(articleCokeA);
        shoppingBagService.addArticleToShoppingBag(articleCokeB);
        shoppingBagService.addArticleToShoppingBag(oranges);

        final List<Article> articles = shoppingBagService.listArticlesOnShoppingBag();
        assertThat(articles).isIn(Arrays.asList(articleBeansA, articleBeansB, articleBeansC, articleCokeA, articleCokeB, oranges));

        final Double subTotalPrice = shoppingBagService.calculateSubTotal();
        assertThat(subTotalPrice).isEqualTo(3.30);

        final List<Offer> offers = shoppingBagService.calculateOffers();
        assertThat(offers).isIn(Arrays.asList(offerBeans, offerCoke));

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.90);

        final Double bill = shoppingBagService.calculateFinalBill();
        assertThat(bill).isEqualTo(2.40);

    }


    @Test
    public void validateOffersByUnitBeansInShoppingBag()
    {
        final Offer offerBeans = null;
        offerBeans.setArticleOfferedName("Beans");
        offerBeans.setOfferType(OfferType.UNITS);
        offerBeans.setOfferValueAforB(2, 2d);


        final Article articleBeansA = null;
        final Article articleBeansB = null;
        final Article articleBeansC = null;

        shoppingBagService.addArticleToShoppingBag(articleBeansA);
        shoppingBagService.addArticleToShoppingBag(articleBeansB);
        shoppingBagService.addArticleToShoppingBag(articleBeansC);

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.50);

    }

    @Test
    public void validateOffersByPriceBeansInShoppingBag()
    {
        final Offer offerCoke = null;
        offerCoke.setArticleOfferedName("Coke");
        offerCoke.setOfferType(OfferType.PRICE);
        offerCoke.setOfferValueAforB(2, 1d);

        final Article articleCokeA = null;
        final Article articleCokeB = null;

        shoppingBagService.addArticleToShoppingBag(articleCokeA);
        shoppingBagService.addArticleToShoppingBag(articleCokeB);

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.40);
    }

}
