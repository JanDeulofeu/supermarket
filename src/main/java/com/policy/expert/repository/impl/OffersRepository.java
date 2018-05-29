package com.policy.expert.repository.impl;

import com.policy.expert.model.Offer;
import com.policy.expert.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class OffersRepository implements Repository<Offer> {

    private final List<Offer> repository = new ArrayList<>();


    @Override
    public void addValue(final Offer value) {
        repository.add(value);
    }


    @Override
    public void remove(final Offer value) {
        repository.remove(value);
    }

    @Override
    public List<Offer> list() {
        return new ArrayList<>(repository);
    }

    @Override
    public void clear() {
        repository.clear();
    }
}
