package com.policy.expert.repository;

import com.policy.expert.model.Article;
import com.policy.expert.model.Offer;
import com.policy.expert.repository.impl.ArticlesRepository;
import com.policy.expert.repository.impl.OffersRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {


    @Test
    public void validateArticleRepositoryReturnsEmptyMapIfEmpty() {
        final Repository<Article> articleRepository = new ArticlesRepository();

        final List<Article> actual = articleRepository.list();

        assertThat(actual).isEmpty();
    }


    @Test
    public void validateAOffereRepositoryReturnsEmptyMapIfEmpty() {
        final Repository<Offer> articleRepository = new OffersRepository();

        final List<Offer> actual = articleRepository.list();

        assertThat(actual).isEmpty();
    }
}