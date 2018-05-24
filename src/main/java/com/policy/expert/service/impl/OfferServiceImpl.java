package com.policy.expert.service.impl;

import com.policy.expert.model.Offer;
import com.policy.expert.repository.Repository;
import com.policy.expert.repository.impl.OffersRepository;
import com.policy.expert.service.OffersService;

import java.util.List;

public class OfferServiceImpl implements OffersService {


    private Repository<Offer> repository = new OffersRepository();

    @Override
    public void addOffer(final Offer offer) {
        repository.addValue(offer.getArticleOfferedName(), offer);
    }

    @Override
    public void removeOffer(final Offer offer) {
        repository.remove(offer.getArticleOfferedName());
    }

    @Override
    public List<Offer> listOffers() {
        return repository.list();
    }

    @Override
    public void clearOffers() {
        repository.clear();
    }
}
