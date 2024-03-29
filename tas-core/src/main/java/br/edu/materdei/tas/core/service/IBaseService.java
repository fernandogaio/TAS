package br.edu.materdei.tas.core.service;

import java.util.List;

public interface IBaseService<T> {
    
    List<T> findAll();
    T findById(Integer id);
    
    T save(T entity);
    
    void delete(Integer id);
    
}
