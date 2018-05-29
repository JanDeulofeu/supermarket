package com.policy.expert.repository.impl;

import com.policy.expert.model.Article;
import com.policy.expert.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ArticlesRepository implements Repository<Article> {

    private final List<Article> repository = new ArrayList<>();


    @Override
    public void addValue(final Article value) {
        repository.add(value);
    }

    @Override
    public void remove(final Article value) {
        repository.remove(value);
    }

    @Override
    public List<Article> list() {
        return new ArrayList<>(repository);
    }

    @Override
    public void clear() {
        repository.clear();
    }

}
