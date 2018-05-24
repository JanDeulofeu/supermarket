package com.policy.expert.repository.impl;

import com.policy.expert.model.Article;
import com.policy.expert.model.impl.ArticleImpl;
import com.policy.expert.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArticlesRepository implements Repository<Article> {

    private final Map<String, Article> repository = new HashMap<>();

    @Override
    public Article getValueByKey(final String key) {

        return repository.containsKey(key) ? repository.get(key) : new ArticleImpl();
    }

    @Override
    public void addValue(final String key, final Article value) {
        repository.putIfAbsent(key, value);
    }

    @Override
    public void remove(final String key) {
        repository.remove(key);
    }

    @Override
    public List<Article> list() {
        return repository.entrySet().stream()
                .map(k -> k.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        repository.clear();
    }


}
