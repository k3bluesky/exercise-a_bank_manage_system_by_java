package dao.impl;

import dao.ManagerDao;
import entity.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerDaoImpl implements ManagerDao {

    @Override
    public DBUtil addUser(DBUtil userData) {
        Scanner sc = new Scanner(System.in);
        List newData = new ArrayList();
        System.out.print("用户卡号：");
        newData.add(sc.nextLine());
        System.out.print("用户密码：");
        newData.add(sc.nextLine());
        System.out.print("用户名：");
        newData.add(sc.nextLine());
        System.out.print("手机号：");
        newData.add(sc.nextLine());
        newData.add("0");
        System.out.print("权限：");
        newData.add(sc.nextLine());
        userData.getUserData().put((String) newData.get(0),newData);
        System.out.println("添加成功");
        return userData;
    }

    @Override
    public DBUtil delUser(DBUtil userData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入删除用户卡号：");
        String cardId = sc.nextLine();
        userData.getUserData().remove(cardId);
        System.out.println("修改成功");
        return userData;
    }

    @Override
    public List findUser(DBUtil userData) {
        System.out.print("请输入查询用户卡号：");
        Scanner sc = new Scanner(System.in);
        String cardId = sc.nextLine();
        List findUserData;
        findUserData = userData.getUserData().get(cardId);
        String[] table = {"卡号：","密码：","用户名：","手机号","余额","权限"};
        int j = 0;
        for (Object i : findUserData) {
            System.out.print(table[j]);
            j++;
            System.out.println(i);
        }
        return findUserData;
    }
}
