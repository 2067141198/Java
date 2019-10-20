package classes;

import Exception.HadLinkmanException;
import Exception.NoOldPhoneNumException;
import Exception.NoSuchLinkmanException;
import Exception.NoThisRemarkException;
import action.Actions;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class User {
    public static void login() {
        Boolean isQuit;
        do{
            User.menu();
            isQuit = User.input();
        } while(!isQuit);
    }
    private static void menu() {
        System.out.println("******************");
        System.out.println("**0.   退出     **");
        System.out.println("**1.添加新联系人**");
        System.out.println("**2.根据姓名查询**");
        System.out.println("**3.修改联系方式**");
        System.out.println("**4.删除联系方式**");
        System.out.println("******************");
    }

    private static Boolean input() {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                return true;
            case 1:
                addLinkman();
                break;
            case 2:
                queryLinkman();
                break;
            case 3:
                setLinkman();
                break;
            case 4:
                deleteLinkman();
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                input();
                break;
        }
        return false;
    }

    /**
     * 添加新的联系人
     */
    private static void addLinkman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("联系人姓名：");
        String name = sc.nextLine();
        System.out.println("联系人备注：");
        String remark = sc.nextLine();
        System.out.println("联系人电话号：");
        String phoneNumber = sc.nextLine();

        try {
            Linkman linkman = Actions.addLinkman(name, remark, phoneNumber);
            System.out.println("联系人" + linkman.getName() + "添加成功！");
        }catch(HadLinkmanException e) {
            System.out.println("通讯录中已有给姓名的联系人，请做以下选择：");
            insertReelectMenu();
            insertInput();
        }
    }

    private static void insertReelectMenu() {
        System.out.println("******************************");
        System.out.println("**0.       返回上一层       **");
        System.out.println("**1.     重新创建联系人     **");
        System.out.println("**2. 修改该联系人的联系方式 **");
        System.out.println("******************************");
    }

    private static void insertInput() {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                login();
                break;
            case 1:
                addLinkman();
                break;
            case 2:
                setLinkman();
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                insertInput();
                break;
        }
    }

    /**
     * 查询联系人
     */
    private static void queryLinkman() {
        queryMenu();
        Map<Linkman, PhoneNumber> linkmanMap = queryInput();
        if(linkmanMap.keySet().size() == 0) {
            System.out.println("通讯录中无该姓名的联系人...");
        } else {
            Set<Map.Entry<Linkman, PhoneNumber>> set = linkmanMap.entrySet();
            int count = 1;
            for(Map.Entry<Linkman, PhoneNumber> e : set) {
                System.out.println("****第" + count++ +"位联系人****");
                System.out.println("联系人姓名：" + e.getKey().getName());
                System.out.println("联系人备注：" + e.getValue().getRemark());
                System.out.print("联系人电话：" );
                for(String s : e.getValue().getPhoneList()) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            System.out.println("**通讯录中一共有位" + set.size() + "联系人**");
        }
    }

    private static void queryMenu() {
        System.out.println("**************************");
        System.out.println("**0.     返回上一层     **");
        System.out.println("**1.   查询所有联系人   **");
        System.out.println("**2. 根据姓名查询联系人 **");
        System.out.println("**************************");
    }
    private static Map<Linkman, PhoneNumber> queryInput() {
        Scanner sc = new Scanner(System.in);
        Map<Linkman, PhoneNumber> map = new TreeMap<>();
        switch(sc.nextInt()) {
            case 0:
                login();
                break;
            case 1:
                map = Actions.queryAllLinkman();
                break;
            case 2:
                sc.nextLine();
                System.out.println("请输入需要查找联系人的姓名：");
                map = Actions.queryAppointLinkman(sc.nextLine());
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                queryInput();
                break;
        }
        return map;
    }

    /**
     * 修改联系人
     */
    private static void setLinkman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的联系人姓名：");
        String name = sc.nextLine();
        try {
            Actions.searchLinkman(name);
            setLinkmanMenu();
            setLinkmanInput(name);
        } catch(NoSuchLinkmanException e) {
            System.out.println("通讯录中未查找到改联系人...");
        }
    }

    private static void setLinkmanMenu() {
        System.out.println("**********************");
        System.out.println("**0.   返回上一层   **");
        System.out.println("**1.  修改备注相关  **");
        System.out.println("**2. 修改电话号相关 **");
        System.out.println("**3. 修改联系人姓名 **");
        System.out.println("**********************");
    }

    private static void setLinkmanInput(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择需要修改的内容：");
        switch(sc.nextInt()) {
            case 0:
                login();
                break;
            case 1:
                setRemark(name);
                break;
            case 2:
                setPhoneNum(name);
                break;
            case 3:
                setLinkmanName(name);
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                setLinkmanInput(name);
                break;
        }
    }

    private static void setLinkmanName(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改后的姓名：");
        String newName = sc.nextLine();
        Actions.setLinkmanName(name, newName);
        System.out.println("修改成功！");
    }

    private static void setPhoneNum(String name) {
        setPhoneNumMenu();
        setPhoneNumInput(name);
    }

    private static void setPhoneNumMenu() {
        System.out.println("**********************");
        System.out.println("**0.   返回上一层   **");
        System.out.println("**1.  修改旧电话号  **");
        System.out.println("**2. 新增新的电话号 **");
        System.out.println("**********************");
    }

    private static void setPhoneNumInput(String name) {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                setLinkman();
                break;
            case 1:
                sc.nextLine();
                System.out.println("请输入要被替换的旧电话号：");
                String oldNum = sc.nextLine();
                System.out.println("请输入要替换的新电话号：");
                String newNum = sc.nextLine();
                try {
                    Actions.replaceOldNum(name, oldNum, newNum);
                } catch (NoOldPhoneNumException e) {
                    System.out.println("新电话号添加成功，通讯录中无与之对应的旧电话号...");
                }
                break;
            case 2:
                sc.nextLine();
                System.out.println("请输入要添加的新电话号：");
                String newNum2 = sc.nextLine();
                try {
                    Actions.replaceOldNum(name, null, newNum2);
                } catch (NoOldPhoneNumException e) {
                    System.out.println("新电话号添加成功，通讯录中无与之对应的旧电话号...");
                }
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                setPhoneNumInput(name);
                break;
        }
    }

    private static void setRemark(String name) {
        setRemarkMenu();
        setRemarkInput(name);
    }

    private static void setRemarkMenu() {
        System.out.println("**********************");
        System.out.println("**0.   返回上一层   **");
        System.out.println("**1. 替换所有旧备注 **");
        System.out.println("**2. 只新增额外备注 **");
        System.out.println("**********************");
    }

    private static void setRemarkInput(String name) {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                setLinkman();
                break;
            case 1:
                sc.nextLine();
                System.out.println("请输入希望置换后的新备注：");
                String remark = sc.nextLine();
                Actions.replaceAllRemark(name, remark);
                System.out.println("修改成功");
                break;
            case 2:
                sc.nextLine();
                System.out.println("请输入希望新增的新备注：");
                String remark2 = sc.nextLine();
                Actions.addNewRemark(name, remark2);
                System.out.println("修改成功");
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                setRemarkInput(name);
                break;
        }
    }

    /**
     * 删除联系人
     */
    private static void deleteLinkman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的联系人：");
        String name = sc.nextLine();
        try{
            Actions.searchLinkman(name);
            deleteLinkmanMenu();
            deleteLinkmanInput(name);
        } catch(NoSuchLinkmanException e) {
            System.out.println("通讯录中未查找到改联系人...");
        }
    }

    private static void deleteLinkmanMenu() {
        System.out.println("************************");
        System.out.println("**0.    返回上一层    **");
        System.out.println("**1.   删除所有信息   **");
        System.out.println("**2.  删除电话号相关  **");
        System.out.println("**3. 删除备注相关信息 **");
        System.out.println("************************");
    }

    private static void deleteLinkmanInput(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你要删除的内容：");
        switch(sc.nextInt()) {
            case 0:
                login();
                break;
            case 1:
                Actions.delAllInformation(name);
                System.out.println("联系人" + name + "删除成功！");
                break;
            case 2:
                delPhoneNum(name);
                break;
            case 3:
                delRemark(name);
                break;
            default:
                System.out.println("请根据菜单进行选择正确的选项，请重新选择：");
                deleteLinkmanInput(name);
                break;
        }
    }

    private static void delPhoneNum(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的电话号：");
        String phoneNum = sc.nextLine();
        try {
            Actions.delPhoneNum(name, phoneNum);
            System.out.println("删除成功！");
        } catch (NoOldPhoneNumException e) {
            System.out.println("删除失败！该联系人无该电话号...");
        }
    }

    private static void delRemark(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的备注信息：");
        String remark = sc.nextLine();
        try {
            Actions.delRemark(name, remark);
            System.out.println("删除成功！");
        } catch (NoThisRemarkException e) {
            System.out.println("删除失败！该联系人无该备注信息...");
        }
    }
}
