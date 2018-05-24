package com.policy.expert.service;

import com.policy.expert.model.Offer;
import com.policy.expert.model.impl.OfferImpl;
import com.policy.expert.service.impl.OfferServiceImpl;
import com.policy.expert.types.OfferType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OffersServiceTest {

    private OffersService offersService = new OfferServiceImpl();


    @BeforeEach
    public void init()
    {
        offersService.clearOffers();
    }

    @Test
    public void validateOffersArePersistedInRepository() {
        final Offer offerBeans = new OfferImpl("Beans", OfferType.UNITS, 3, 2d);
        final Offer offerCoke = new OfferImpl("Coke", OfferType.UNITS, 10, 5d);

        offersService.addOffer(offerBeans);
        offersService.addOffer(offerCoke);

        final List<Offer> actual = offersService.listOffers();

        assertThat(actual).isNotNull();
        assertThat(actual).contains(offerBeans, offerCoke);

    }

    @Test
    public void validateOffersAreRemovedFromRepository()
    {
        final Offer offerBeans = new OfferImpl("Beans", OfferType.UNITS, 3, 2d);
        final Offer offerCoke = new OfferImpl("Coke", OfferType.UNITS, 10, 5d);

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