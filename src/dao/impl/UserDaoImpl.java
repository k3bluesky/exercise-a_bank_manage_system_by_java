package dao.impl;

import dao.UserDao;
import entity.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
    @Override
    public DBUtil deposit(DBUtil data, String cardId) {
        Scanner sc = new Scanner(System.in);
        List temp;
        temp = data.getUserData().get(cardId);
        System.out.print("存入金额：");
        String x = Integer.toString(Integer.parseInt((String) temp.get(4))+sc.nextInt());
        List temp_2 = new ArrayList(temp);
        temp_2.set(4,x);
        data.getUserData().put(cardId,temp_2);
        System.out.println("存入成功！\n");
        return data;
    }

    @Override
    public DBUtil withdrawal(DBUtil data, String cardId) {
        Scanner sc = new Scanner(System.in);
        List temp;
        temp = data.getUserData().get(cardId);
        System.out.print("取出金额：");
        int outMoney=sc.nextInt();
        if (Integer.parseInt((String) temp.get(4))-outMoney<0){
            System.out.print("余额不足\n");
            return data;
        }else{
            String x = Integer.toString(Integer.parseInt((String) temp.get(4))-outMoney);
            List temp_2 = new ArrayList(temp);
            temp_2.set(4,x);
            data.getUserData().put(cardId,temp_2);
            System.out.println("取出成功！\n");
            return data;
        }
    }

    @Override
    public void findBalance(DBUtil data, String cardId) {
        List temp = new ArrayList();
        temp = data.getUserData().get(cardId);
        System.out.println("余额:"+temp.get(4));
    }
}
