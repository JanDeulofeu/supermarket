package com.policy.expert;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.model.impl.ArticleImpl;
import com.policy.expert.model.impl.OfferImpl;
import com.policy.expert.service.ShoppingBagService;
import com.policy.expert.service.impl.ShoppingBagServiceImpl;
import com.policy.expert.types.ItemType;
import com.policy.expert.types.OfferType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingJourneyTest {

    private ShoppingBagService shoppingBagService = new ShoppingBagServiceImpl();

    @Test
    public void validateShoppingBasketReceipt() {

        final Offer offerBeans = new OfferImpl();
        offerBeans.setArticleOfferedName("Beans");
        offerBeans.setOfferType(OfferType.UNITS);
        offerBeans.setOfferValueAforB(2, 2d);

        final Offer offerCoke = new OfferImpl();
        offerCoke.setArticleOfferedName("Coke");
        offerCoke.setOfferType(OfferType.PRICE);
        offerCoke.setOfferValueAforB(2, 1d);

        shoppingBagService.getOffersService().addOffer(offerBeans);
        shoppingBagService.getOffersService().addOffer(offerCoke);

        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansC = new ArticleImpl("Beans", 0.50d);
        final Article articleCokeA = new ArticleImpl("Coke", 0.70d);
        final Article articleCokeB = new ArticleImpl("Coke", 0.70d);
        final Article oranges = new ArticleImpl("Oranges", 0.40d, ItemType.WEIGHT, "0.200 kg @ £1.99/kg");

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

        final List<Offer> offers = shoppingBagService.getOffers();
        assertThat(offers).isIn(Arrays.asList(offerBeans, offerCoke));

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.90);

        final Double bill = shoppingBagService.calculateFinalBill();
        assertThat(bill).isEqualTo(2.40);

    }

    @Test
    public void validateOffersByUnitBeansInShoppingBag() {
        final Offer offerBeans = new OfferImpl();
        offerBeans.setArticleOfferedName("Beans");
        offerBeans.setOfferType(OfferType.UNITS);
        offerBeans.setOfferValueAforB(2, 2d);

        shoppingBagService.getOffersService().addOffer(offerBeans);

        final Article articleBeansA = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansB = new ArticleImpl("Beans", 0.50d);
        final Article articleBeansC = new ArticleImpl("Beans", 0.50d);

        shoppingBagService.addArticleToShoppingBag(articleBeansA);
        shoppingBagService.addArticleToShoppingBag(articleBeansB);
        shoppingBagService.addArticleToShoppingBag(articleBeansC);

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.50);

    }

    @Test
    public void validateOffersByPriceBeansInShoppingBag() {
        final Offer offerCoke = new OfferImpl();
        offerCoke.setArticleOfferedName("Coke");
        offerCoke.setOfferType(OfferType.PRICE);
        offerCoke.setOfferValueAforB(2, 1d);

        shoppingBagService.getOffersService().addOffer(offerCoke);

        final Article articleCokeA = new ArticleImpl("Coke", 0.70d);
        final Article articleCokeB = new ArticleImpl("Coke", 0.70d);

        shoppingBagService.addArticleToShoppingBag(articleCokeA);
        shoppingBagService.addArticleToShoppingBag(articleCokeB);

        final Double discount = shoppingBagService.calculateDiscount();
        assertThat(discount).isEqualTo(-0.40);
    }

}
