package com.test.service;

public interface Service<T> {

    T get(Long id) throws Exception;

    void add(T obj) throws Exception;

    void edit(T obj) throws Exception;

    void delete(T obj) throws Exception;

}
