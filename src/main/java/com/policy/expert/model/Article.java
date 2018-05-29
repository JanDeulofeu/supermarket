package com.policy.expert.model;

import com.policy.expert.types.ItemType;

public interface Article {

    String getArticleName();

    Double getPrice();

    ItemType getArticlePriceType();

    String getCharacteristics();
}
