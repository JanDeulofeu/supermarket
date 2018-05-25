package com.policy.expert.calculator.impl;

import com.policy.expert.calculator.DiscountCalculator;
import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.types.OfferType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountCalculatorImpl implements DiscountCalculator {


    @Override
    public Double calculateDiscount(final List<Article> articles, final List<Offer> offers) {

        return articles.stream()
                .distinct()
                .map(k -> calculateDiscountByArticle(k.getArticleName(), articles, offers))
                .reduce(0d, (x, y) -> x + y);
    }

    @Override
    public Double calculateDiscountByArticle(final String article, final List<Article> articles, final List<Offer> offers) {

        Double discount = 0d;

        final List<Double> articlesPrices = articles.stream()
                .filter(k -> k.getArticleName().equalsIgnoreCase(article))
                .map(k -> k.getPrice())
                .collect(Collectors.toList());


        if (articlesPrices.isEmpty()) {
            return 0d;
        }

        discount = calculateDiscountByUnits(article, offers, discount, articlesPrices);
        discount = calculateDiscountByPrice(article, offers, discount, articlesPrices);

        return roundDiscount(discount);
    }


    private Double calculateDiscountByUnits(final String article, final List<Offer> offers, Double discount, final List<Double> articlesPrices) {

        final Optional<Offer> offerUnitsOptional =  filterOffersByTypeAndArticleName(OfferType.UNITS, article, offers);

        if (offerUnitsOptional.isPresent()) {

            final Offer offer = offerUnitsOptional.get();
            final int numberBlocs = (articlesPrices.size() % offer.getOfferValueA()) + 1;

            final Double sumPrices = articlesPrices.stream().reduce(0d, (x, y) -> x + y);

            final Double percentageValue = (offer.getOfferValueB() * (offer.getOfferValueA() * articlesPrices.get(0))) / offer.getOfferValueA();
            discount = -(sumPrices - (numberBlocs * percentageValue));

        }
        return discount;
    }

    private Double calculateDiscountByPrice(final String article, final List<Offer> offers, Double discount, final List<Double> articlesPrices) {

        final Optional<Offer> offerUnitsOptional = filterOffersByTypeAndArticleName(OfferType.PRICE, article, offers);

        if (offerUnitsOptional.isPresent()) {

            final Offer offer = offerUnitsOptional.get();
            final int numberBlocs = (articlesPrices.size() % offer.getOfferValueA()) + 1;

            discount = -(numberBlocs * ((offer.getOfferValueA() * articlesPrices.get(0)) - offer.getOfferValueB()));

        }
        return discount;
    }

    private Optional<Offer> filterOffersByTypeAndArticleName(final OfferType offerType, final String article, final List<Offer> offers){
        return offers.stream()
                .filter(k -> k.getArticleOfferedName().equalsIgnoreCase(article))
                .filter(k -> k.getOfferType() == offerType)
                .findFirst();
    }

    private Double roundDiscount(final Double value) {
        return new BigDecimal(value > 0 ? -value : value).setScale(2, BigDecimal.ROUND_UP).doubleValue();
    }
}
