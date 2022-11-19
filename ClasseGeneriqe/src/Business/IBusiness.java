package Business;

import java.util.List;

public interface IBusiness<T> {
    public T add(T object);
    public List<T> getAll();
    public T findById(long id);
    public void delete(long id);
    public void saveAll
}
