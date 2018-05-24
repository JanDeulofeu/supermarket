package com.policy.expert.repository;

import com.policy.expert.model.Article;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {


    @Test
    public void validateArticleRepositoryReturnsEmptyMapIfEmpty() {
        final Repository<Article> articleRepository = null;

        final Map<String, Article> actual = articleRepository.getValueByKey("key");

        assertThat(actual).isEmpty();
    }
}