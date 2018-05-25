package com.policy.expert.service;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.model.impl.ArticleImpl;
import com.policy.expert.service.impl.ShoppingBagServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBagServiceTest {


    private ShoppingBagService shoppingBagService = new ShoppingBagServiceImpl();


    @BeforeEach
    public void init() {
        shoppingBagService.clearBag();
    }


    @Test
    public void validateArticlesArePersistedInRepository() {
        final Article articleBeans = new ArticleImpl();
        final Article articleCoke = new ArticleImpl();


        shoppingBagService.addArticleToShoppingBag(articleBeans);
        shoppingBagService.addArticleToShoppingBag(articleCoke);

        final List<Article> actual = shoppingBagService.listArticlesOnShoppingBag();

        assertThat(actual).isNotNull();
        assertThat(actual).contains(articleBeans, articleCoke);
    }

    @Test
    public void validateArticlesAreRemovedFromRepository() {
        final Article articleBeans = new ArticleImpl();
        final Article articleCoke = new ArticleImpl();

        shoppingBagService.addArticleToShoppingBag(articleBeans);
        shoppingBagService.addArticleToShoppingBag(articleCoke);

        shoppingBagService.removeArticleFromShoppingBag(articleBeans);

        final List<Article> actual = shoppingBagService.listArticlesOnShoppingBag();

        assertThat(actual).containsExactly(articleCoke);
    }

    @Test
    public void validateArticleRepositoryReturnsEmptyCollectionIfEmpty() {
        final List<Article> actual = shoppingBagService.listArticlesOnShoppingBag();
        assertThat(actual).isNotNull();
        assertThat(actual).isEmpty();
    }

    @Test
    public void validateCalculateTotalShoppingReturnsZeroIfEmpty() {
        final Double expected = 0d;
        final Double actual = shoppingBagService.calculateFinalBill();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void validateCalculateFinalBillReturnsZeroIfEmpty() {
        final Double expected = 0d;
        final Double actual = shoppingBagService.calculateFinalBill();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void validateCalculateOffersReturnsEmptyCollectionIfEmpty() {
        final List<Offer> actual = shoppingBagService.getOffers();

        assertThat(actual).isNotNull();
        assertThat(actual).isEmpty();
    }
}