package com.policy.expert.calculator;

import com.policy.expert.model.Article;

import java.util.List;

public interface BillCalculator {

    Double calculateBill(List<Article> articles, Double discount);
}
