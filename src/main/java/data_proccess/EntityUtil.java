package data_proccess;

import java.util.List;

public interface EntityUtil<T> {

    public void addEntity(T t);

    public boolean entityExists(T t);

    public List<T> selectAll();


}
