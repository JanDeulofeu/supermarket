package com.policy.expert.service;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;

import java.util.List;

public interface ShoppingBagService {

    OffersService getOffersService();

    void addArticleToShoppingBag(Article article);

    void removeArticleFromShoppingBag(Article article);

    List<Article> listArticlesOnShoppingBag();

    void clearBag();

    Double calculateSubTotal();

    Double calculateDiscount();

    List<Offer> getOffers();

    Double calculateFinalBill();
}
