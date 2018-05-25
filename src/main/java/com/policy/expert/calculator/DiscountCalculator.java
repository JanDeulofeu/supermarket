package com.policy.expert.calculator;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;

import java.util.List;

public interface DiscountCalculator {

    Double calculateDiscount(List<Article> articles, List<Offer> offers);

    Double calculateDiscountByArticle(String article, List<Article> articles, List<Offer> offers);
}
