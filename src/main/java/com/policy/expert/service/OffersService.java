package com.policy.expert.service;

import com.policy.expert.model.Offer;

import java.util.List;

public interface OffersService {

    void addOffer(Offer offer);

    void removeOffer(Offer offer);

    List<Offer> listOffers();

    void clearOffers();
}
