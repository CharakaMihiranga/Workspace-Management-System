package lk.ijse.coworkhub.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {

    ArrayList<T> getAll();
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto);
    boolean exist(String id);
    void delete(String id);
    String generateID();
    T search(String id);

}
