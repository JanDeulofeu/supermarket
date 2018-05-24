package com.policy.expert.repository;

import java.util.List;

public interface Repository<T> {

    void addValue(T value);

    void remove(T value);

    List<T> list();

    void clear();
}
