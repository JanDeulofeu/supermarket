package com.policy.expert.repository;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.repository.impl.ArticlesRepository;
import com.policy.expert.repository.impl.OffersRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {


    @Test
    public void validateArticleRepositoryReturnsEmptyMapIfEmpty() {
        final Repository<Article> articleRepository = new ArticlesRepository();

        final Article actual = articleRepository.getValueByKey("key");

        assertThat(actual).isNotNull();
    }


    @Test
    public void validateAOffereRepositoryReturnsEmptyMapIfEmpty() {
        final Repository<Offer> articleRepository = new OffersRepository();

        final Offer actual = articleRepository.getValueByKey("key");

        assertThat(actual).isNotNull();
    }
}