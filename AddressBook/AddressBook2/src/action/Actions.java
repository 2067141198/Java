package action;

import Exception.HadLinkmanException;
import Exception.NoOldPhoneNumException;
import Exception.NoSuchLinkmanException;
import Exception.NoThisRemarkException;
import classes.Linkman;
import classes.PhoneNumber;
import databases.PhoneNumShelf;

import java.util.Map;

public class Actions {
    public static Linkman addLinkman(String name, String remark, String phoneNumber) throws HadLinkmanException {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        Linkman linkman = phoneNumShelf.search(name);
        phoneNumShelf.addLinkman(name, remark,phoneNumber);
        return linkman;
    }

    public static Map<Linkman, PhoneNumber> queryAllLinkman() {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        return phoneNumShelf.queryAllLinkman();
    }

    public static Map<Linkman, PhoneNumber> queryAppointLinkman(String name) {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        return phoneNumShelf.queryAppointLinkman(name);
    }

    public static void setLinkmanName(String oldName, String newName){
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.setlinkmanName(oldName, newName);
    }

    public static void replaceOldNum(String name, String oldNum, String newNum) throws NoOldPhoneNumException {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.replaceOldNum(name, oldNum, newNum);
    }

    public static void replaceAllRemark(String name, String remark) {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.replaceAllRemark(name, remark);
    }

    public static void addNewRemark(String name, String remark) {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.addNewRemark(name, remark);
    }

    public static void searchLinkman(String name) throws NoSuchLinkmanException {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.searchOfSet(name);
    }

    public static void delAllInformation(String name) {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.delAllInformation(name);
    }

    public static void delPhoneNum(String name, String phoneNum) throws NoOldPhoneNumException {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.delPhoneNum(name, phoneNum);
    }

    public static void delRemark(String name, String remark) throws NoThisRemarkException {
        PhoneNumShelf phoneNumShelf = PhoneNumShelf.getInstance();
        phoneNumShelf.delRemark(name, remark);
    }
}
