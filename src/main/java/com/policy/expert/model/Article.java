package com.policy.expert.model;

import com.policy.expert.types.ItemType;

public interface Article {

    String getArticleName();

    void setArticleName(String name);

    Double getPrice();

    void setPrice(Double price);

    ItemType getArticlePriceType();

    void setArticlePriceType(ItemType itemType);

    String getCharacteristics();

    void setCharacteristics();
}
