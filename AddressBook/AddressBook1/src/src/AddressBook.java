package src;

import java.util.*;

public class AddressBook {
    private static Map<String, PhoneNumShelf> map = new TreeMap<>();

    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("联系人姓名：");
        String name = sc.nextLine();
        System.out.println("联系人备注：");
        String remark = sc.nextLine();
        System.out.println("联系人电话号：");
        String phoneNumber = sc.nextLine();

        PhoneNumShelf phoneNumShelf = new PhoneNumShelf();
        phoneNumShelf.setRemark(remark);
        List<String> numList = phoneNumShelf.getNumList();
        if(numList == null) {
            numList = new ArrayList<>();
        }
        numList.add(phoneNumber);

        map.put(name, phoneNumShelf);
        System.out.println("添加成功");
    }

    public static void query() {
        Set<String> keySet = map.keySet();
        for(String string : keySet) {
            PhoneNumShelf phf = map.get(string);
            List<String> numList = phf.getNumList();
            System.out.println("姓名：" + string);
            System.out.println("备注：" + phf.getRemark());
            System.out.println("电话号：");
            for(String s : numList) {
                System.out.println(s + " ");
            }
        }
    }

    public static void set() throws NoSuchLinkmanException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改联系人的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入要修改的备注：");
        String remark = sc.nextLine();
        System.out.println("请输入要添加的电话：");
        String phoneNum = sc.nextLine();
        if(map.containsKey(name)) {
            PhoneNumShelf phf = map.get(name);
            phf.setRemark(remark);
            List<String> numList = phf.getNumList();
            for(String string : numList) {
                if(string.equals(phoneNum))
                    System.out.println("已有该联系方式！");
            }
            numList.add(phoneNum);
        } else {
            throw new NoSuchLinkmanException("通讯录中无该用户的联系方式！");
        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除联系人的姓名：");
        map.remove(sc.nextLine());
    }
}
