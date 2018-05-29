package com.policy.expert.model.impl;

import com.policy.expert.model.Offer;
import com.policy.expert.types.OfferType;

import java.util.Objects;

public class OfferImpl implements Offer {

    private String articleName;
    private OfferType offerType;
    private Integer offerValueA;
    private Double offerValueB;

    public OfferImpl() {
    }

    public OfferImpl(final String articleName, final OfferType offerType, final Integer offerValueA, final Double offerValueB) {
        this.articleName = articleName;
        this.offerType = offerType;
        this.offerValueA = offerValueA;
        this.offerValueB = offerValueB;
    }

    @Override
    public String getArticleOfferedName() {
        return articleName;
    }

    @Override
    public void setArticleOfferedName(final String articleName) {
        this.articleName = articleName;

    }

    @Override
    public OfferType getOfferType() {
        return offerType;
    }

    @Override
    public void setOfferType(final OfferType offerType) {
        this.offerType = offerType;

    }

    @Override
    public Integer getOfferValueA() {
        return offerValueA;
    }

    @Override
    public Double getOfferValueB() {
        return offerValueB;
    }

    @Override
    public void setOfferValueAforB(final Integer offerValueA, final Double offerValueB) {
        this.offerValueA = offerValueA;
        this.offerValueB = offerValueB;

    }

    @Override
    public String toString() {
        return "OfferImpl{" +
                "articleName='" + articleName + '\'' +
                ", offerType=" + offerType +
                ", offerValueA=" + offerValueA +
                ", offerValueB=" + offerValueB +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OfferImpl offer = (OfferImpl) o;
        return Objects.equals(articleName, offer.articleName) &&
                offerType == offer.offerType &&
                Objects.equals(offerValueA, offer.offerValueA) &&
                Objects.equals(offerValueB, offer.offerValueB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleName, offerType, offerValueA, offerValueB);
    }
}
