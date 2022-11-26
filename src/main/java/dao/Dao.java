package dao;

import java.util.List;

public interface Dao<T>{
    List<T> getAll();
    T get(Long id);
    void update(Long id);
    void delete(Long id);
}
