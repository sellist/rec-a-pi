package recipeapi.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

interface AbstractService<T, ID> {

    List<T> getAll();

    T create(T t);

    void delete(ID id);

    T get(ID id);

    @Transactional
    int updateObject(T t);
}
