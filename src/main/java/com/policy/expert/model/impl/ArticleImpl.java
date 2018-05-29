package com.policy.expert.model.impl;

import com.policy.expert.model.Article;
import com.policy.expert.types.ItemType;

import java.util.Objects;

public class ArticleImpl implements Article {

    private String name;
    private Double price;
    private ItemType itemType = ItemType.PRICE;
    private String characteristics;


    public ArticleImpl() {
    }

    public ArticleImpl(final String name, final Double price) {
        this.name = name;
        this.price = price;
    }


    public ArticleImpl(final String name, final Double price, final ItemType itemType) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    public ArticleImpl(final String name, final Double price, final ItemType itemType, final String characteristics) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.characteristics = characteristics;
    }

    @Override
    public String getArticleName() {
        return name;
    }


    @Override
    public Double getPrice() {
        return price;
    }


    @Override
    public ItemType getArticlePriceType() {
        return itemType;
    }


    @Override
    public String getCharacteristics() {
        return characteristics;
    }


    @Override
    public String toString() {
        return "ArticleImpl{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", itemType=" + itemType +
                ", characteristics='" + characteristics + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ArticleImpl article = (ArticleImpl) o;
        return Objects.equals(name, article.name) &&
                Objects.equals(price, article.price) &&
                itemType == article.itemType &&
                Objects.equals(characteristics, article.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, itemType, characteristics);
    }
}
