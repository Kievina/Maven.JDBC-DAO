package daos;

import java.util.List;

public interface Dao<T extends Dto> {
    T findById(int id);
    List findAll();
    T update(T dto);
    T create(T dto);
    void delete(int id);
}
