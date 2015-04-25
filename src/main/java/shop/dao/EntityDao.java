package shop.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntityDao<T> {
    public void addEntity(T t);

    public boolean entityExists(T t);

    public List<T> selectAll();
}
