package freelancee.dao;

import java.util.List;


public interface IGenericDAO<T> {
    void add(T entity);
    List<T> getAll();
}