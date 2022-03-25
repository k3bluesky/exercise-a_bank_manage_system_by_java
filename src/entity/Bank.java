package entity;

import entity.DBUtil;

import java.util.*;

public class Bank {
    Scanner sc = new Scanner(System.in);

    public String userLogin(DBUtil saveData){
        String cardId;
        String cardPwd;
        System.out.print("请输入卡号：");
        cardId = sc.nextLine();
        System.out.print("请输入密码：");
        cardPwd = sc.nextLine();
        Map<String, List> userData;
        userData = saveData.getUserData();
        if (userData.get(cardId)!=null){
            List data = userData.get(cardId);
            if(cardPwd.equals(data.get(1))){
                return (String) data.get(0);
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("无此卡号");
        }
        return String.valueOf(1);
    }
}
