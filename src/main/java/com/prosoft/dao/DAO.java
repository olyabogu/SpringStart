package com.prosoft.dao;



/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:33 PM
 */
public interface DAO<T> {

    T get(Long id) ;

    void delete(T obj) ;

    void edit(T obj);

    void add(T obj);

}
