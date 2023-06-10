package recipeapi.service;

import java.util.List;

interface AbstractService<T> {

    public List<T> getAll();

    public T create(T t);

    public void delete(Long id);

    public T get(Long id);
}
