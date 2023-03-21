package Models.DAO;

import java.sql.SQLException;
import java.util.List;

public interface inteface<T> {
        public void create(T object) throws Exception;
        public T read(int id) throws Exception;
        public void update(T object) throws Exception;
        public void delete(T object) throws Exception;
        public List<T> all() throws Exception;


}
