
import dao.ManagerDao;
import dao.UserDao;
import dao.impl.ManagerDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Bank;
import entity.DBUtil;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class mainSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("welcome!");
            DBUtil data = new DBUtil();
            data = initializeData();
            Bank bank = new Bank();

            String cardId ;
            do {
                cardId = bank.userLogin(data);
            }while (cardId.equals("1"));
            System.out.println("登录成功！欢迎卡号"+cardId+"的用户");

            User user = new User();
            user = getOneData(data,cardId);
            while(true) {
                System.out.print("请选择下一步操作\n1:存款\n2:取款\n3:查询余额\n9:验证管理员身份\n0:退出系统\n");
                UserDao userDao = new UserDaoImpl();

                int userChose = sc.nextInt();
                switch (userChose) {
                    case 1:
                        userDao.deposit(data,cardId);
                        break;
                    case 2:
                        userDao.withdrawal(data,cardId);
                        break;
                    case 3:
                        userDao.findBalance(data,cardId);
                        break;
                    case 9:
                        if (user.getManage().equals("0")) {
                            while (true) {
                                System.out.print("请选择下一步操作\n1:添加用户\n2:删除用户\n3:查询用户\n0:退出管理系统\n");
                                ManagerDao managerDao = new ManagerDaoImpl();
                                int managerChose = sc.nextInt();
                                switch (managerChose) {
                                    case 1:
                                        managerDao.addUser(data);
                                        break;
                                    case 2:
                                        managerDao.delUser(data);
                                        break;
                                    case 3:
                                        managerDao.findUser(data);
                                        break;
                                    case 0:
                                        break;
                                }
                                if (managerChose == 0) {
                                    System.out.print("成功退出系统");
                                    break;
                                }
                            }
                        } else {
                            System.out.print("你没有管理员权限！");
                        }

                    case 0:break;
                }
                if (userChose == 0)
                {
                    System.out.print("成功退出系统");
                    break;
                }
            }
            System.out.println("要登录其他账号请输入y");
            if (sc.nextLine().equalsIgnoreCase("y")){
                continue;
            }else{
                System.out.println("退出系统");
                break;
            }
        }
    }

    public static DBUtil initializeData(){//初始化数据集
        DBUtil data = new DBUtil();
        Map<String, List> Data = new HashMap<String, List>();
        String[] Data1 = new String[]{"123123123", "password","admin", "13600011223", "114514", "0"};//0为管理员
        String[] Data2 = new String[]{"112233445", "password","lihua","13600011223", "114514", "1"};
        Data.put("123123123", List.of(Data1));
        Data.put("112233445", List.of(Data2));
        data.setUserData(Data);
        return data;
    }

    public static User getOneData(DBUtil userData, String cardId){//提取登录用户资料
        List data;
        User user = new User();
        data = userData.getUserData().get(cardId);
        user.setCardId((String) data.get(0));
        user.setCardPwd((String) data.get(1));
        user.setUserName((String) data.get(2));
        user.setCall((String) data.get(3));
        user.setAccount((String) data.get(4));
        user.setManage((String) data.get(5));
        return user;
    }

}
