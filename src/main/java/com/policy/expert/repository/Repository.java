package com.policy.expert.repository;

import java.util.List;

public interface Repository<T> {

    T getValueByKey(String key);

    void addValue(String key, T value);

    void remove(String key);

    List<T> list();

    void clear();
}
