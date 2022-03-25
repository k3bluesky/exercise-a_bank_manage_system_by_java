package dao;

import entity.DBUtil;

public interface UserDao {
    public DBUtil deposit(DBUtil data,String cardId);
    public DBUtil withdrawal(DBUtil data,String cardId);
    public void findBalance(DBUtil data,String cardId);
}
