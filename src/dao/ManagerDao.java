package dao;

import entity.DBUtil;
import java.util.List;

public interface ManagerDao {
    public DBUtil addUser(DBUtil userData);
    public DBUtil delUser(DBUtil userData);
    public List findUser(DBUtil userData);
}
