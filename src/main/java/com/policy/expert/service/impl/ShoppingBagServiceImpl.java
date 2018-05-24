package com.policy.expert.service.impl;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.repository.Repository;
import com.policy.expert.repository.impl.ArticlesRepository;
import com.policy.expert.service.OffersService;
import com.policy.expert.service.ShoppingBagService;

import java.util.List;

public class ShoppingBagServiceImpl implements ShoppingBagService {

    private Repository<Article> repository = new ArticlesRepository();
    private OffersService offersService = new OfferServiceImpl();


    @Override
    public OffersService getOffersService() {
        return offersService;
    }

    @Override
    public void addArticleToShoppingBag(final Article article) {
        repository.addValue(article);
    }

    @Override
    public void removeArticleFromShoppingBag(final Article article) {
        repository.remove(article);
    }

    @Override
    public List<Article> listArticlesOnShoppingBag() {
        return repository.list();
    }

    @Override
    public void clearBag() {
        repository.clear();
    }

    @Override
    public Double calculateSubTotal() {
        return null;
    }

    @Override
    public Double calculateDiscount() {
        return null;
    }

    @Override
    public List<Offer> calculateOffers() {
        return offersService.listOffers();
    }

    @Override
    public Double calculateFinalBill() {
        return null;
    }
}
