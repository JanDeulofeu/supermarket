package com.policy.expert.service.impl;

import com.policy.expert.calculator.BillCalculator;
import com.policy.expert.calculator.DiscountCalculator;
import com.policy.expert.calculator.impl.BillCalculatorImpl;
import com.policy.expert.calculator.impl.DiscountCalculatorImpl;
import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.repository.Repository;
import com.policy.expert.repository.impl.ArticlesRepository;
import com.policy.expert.service.OffersService;
import com.policy.expert.service.ShoppingBagService;

import java.util.List;

public class ShoppingBagServiceImpl implements ShoppingBagService {

    private DiscountCalculator discountCalculator = new DiscountCalculatorImpl();
    private Repository<Article> articleRepository = new ArticlesRepository();
    private BillCalculator billCalculator = new BillCalculatorImpl();
    private OffersService offersService = new OfferServiceImpl();

    @Override
    public OffersService getOffersService() {
        return offersService;
    }

    @Override
    public void addArticleToShoppingBag(final Article article) {
        articleRepository.addValue(article);
    }

    @Override
    public void removeArticleFromShoppingBag(final Article article) {
        articleRepository.remove(article);
    }

    @Override
    public List<Article> listArticlesOnShoppingBag() {
        return articleRepository.list();
    }

    @Override
    public void clearBag() {
        articleRepository.clear();
    }

    @Override
    public Double calculateSubTotal() {
        return billCalculator.calculateSubTotal(articleRepository.list());
    }

    @Override
    public Double calculateDiscount() {
        return discountCalculator.calculateDiscount(articleRepository.list(), offersService.listOffers());
    }

    @Override
    public List<Offer> getOffers() {
        return offersService.listOffers();
    }

    @Override
    public Double calculateFinalBill() {
        return billCalculator.calculateBill(articleRepository.list(), calculateDiscount());
    }
}
