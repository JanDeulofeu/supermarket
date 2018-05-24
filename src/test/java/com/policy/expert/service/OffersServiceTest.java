package com.policy.expert.service;

import com.policy.expert.model.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OffersServiceTest {

    private OffersService offersService;


    @BeforeEach
    public void init()
    {
        offersService.clearOffers();
    }

    @Test
    public void validateOffersArePersistedInRepository() {
        final Offer offerBeans = null;
        final Offer offerCoke = null;

        offersService.addOffer(offerBeans);
        offersService.addOffer(offerCoke);

        final List<Offer> actual = offersService.listOffers();

        assertThat(actual).isNotNull();
        assertThat(actual).contains(offerBeans, offerCoke);

    }

    @Test
    public void validateOffersAreRemovedFromRepository()
    {
        final Offer offerBeans = null;
        final Offer offerCoke = null;

        offersService.addOffer(offerBeans);
        offersService.addOffer(offerCoke);

        offersService.removeOffer(offerCoke);

        final List<Offer> actual = offersService.listOffers();

        assertThat(actual).containsExactly(offerBeans);
    }

    @Test
    public void validateOfferRepositoryReturnsEmptyCollectionIfEmpty()
    {
        final List<Offer> actual = offersService.listOffers();
        assertThat(actual).isNotNull();
        assertThat(actual).isEmpty();
    }

}