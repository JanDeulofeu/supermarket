package com.policy.expert.model;

import com.policy.expert.types.OfferType;

public interface Offer {

    String getArticleOfferedName();

    void setArticleOfferedName(String articleName);

    OfferType getOfferType();

    void setOfferType(OfferType offerType);

    Integer getOfferValueA();

    Double getOfferValueB();

    void setOfferValueAforB(Integer a, Double b);
}
