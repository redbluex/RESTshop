package pl.redblue.shop.service;

import java.util.List;

public interface ServiceInterface<T> {
    List<T> getObjects();
    T create(T obj);
    T findById(String id);
    T update(String id, T obj);
}
