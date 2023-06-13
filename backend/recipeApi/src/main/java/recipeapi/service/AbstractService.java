package recipeapi.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

interface AbstractService<T, I> {

    List<T> getAll();

    T create(T t);

    void delete(I id);

    T get(I id);

    @Transactional
    int updateObject(T t);

    int updateObject(T t, Integer id);
}
