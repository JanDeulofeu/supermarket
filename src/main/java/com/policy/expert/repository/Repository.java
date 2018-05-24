package com.policy.expert.repository;

import java.util.Map;

public interface Repository<T> {

    Map<String, T> getValueByKey(String key);

    void addValue(String key, T value);
}
