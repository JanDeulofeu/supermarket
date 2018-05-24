package com.policy.expert.repository.impl;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.model.impl.OfferImpl;
import com.policy.expert.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OffersRepository implements Repository<Offer> {

    private final Map<String, Offer> repository = new HashMap<>();

    @Override
    public Offer getValueByKey(final String key) {

        return repository.containsKey(key) ? repository.get(key) : new OfferImpl();
    }

    @Override
    public void addValue(final String key, final Offer value) {
        repository.putIfAbsent(key, value);
    }


    @Override
    public void remove(final String key) {
        repository.remove(key);
    }

    @Override
    public List<Offer> list() {
        return repository.entrySet().stream()
                .map(k -> k.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        repository.clear();
    }
}
