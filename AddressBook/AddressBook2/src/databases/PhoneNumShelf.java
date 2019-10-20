package databases;

import Exception.HadLinkmanException;
import Exception.NoOldPhoneNumException;
import Exception.NoSuchLinkmanException;
import Exception.NoThisRemarkException;
import classes.Linkman;
import classes.PhoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneNumShelf {
    private static Map<Linkman, PhoneNumber> map= new TreeMap<>();

    private static PhoneNumShelf instance = new PhoneNumShelf();
    public static PhoneNumShelf getInstance() {
        return instance;
    }

    public Linkman search(String name) throws HadLinkmanException {
        Linkman linkman = new Linkman(name);
        if(map.containsKey(linkman))
            throw new HadLinkmanException();
        else
            return linkman;
    }

    public void addLinkman(String name, String remark, String phoneNumber) {
        List<String> list = new ArrayList<>();
        list.add(phoneNumber);
        PhoneNumber ph = new PhoneNumber(remark, list);
        map.put(new Linkman(name), ph);
    }

    public Map<Linkman, PhoneNumber> queryAllLinkman() {
        return new TreeMap<>(map);
    }

    public Map<Linkman, PhoneNumber> queryAppointLinkman(String name) {
        Map<Linkman, PhoneNumber> result = new TreeMap<>();
        Linkman linkman = new Linkman(name);
        if(map.containsKey(linkman))
            result.put(linkman, map.get(linkman));
        return result;
    }

    public void setlinkmanName(String oldName, String newName) {
        Linkman linkman = new Linkman(oldName);
        PhoneNumber pn = map.get(linkman);
        map.remove(linkman);
        map.put(new Linkman(newName), pn);
    }

    public void replaceOldNum(String name, String oldNum, String newNum) throws NoOldPhoneNumException {
        Linkman linkman = new Linkman(name);

        PhoneNumber pn = map.get(linkman);
        List<String> list = pn.getPhoneList();
        //不论旧电话是否为null， 首先将新号添加到电话的表中
        list.add(newNum);
        //遍历整个存电话号的list，如果存在旧的电话号就删除，否则抛出异常
        //即不论旧的电话是否存在新电话一定会添加进去
        for(String string : list) {
            if(string.equals(oldNum)) {
                list.remove(string);
                return;
            }
        }
        throw new NoOldPhoneNumException();
    }

    public void replaceAllRemark(String name, String remark) {
        Linkman linkman = new Linkman(name);
        PhoneNumber pn = map.get(linkman);
        pn.setRemark(remark);
    }

    public void addNewRemark(String name, String remark) {
        Linkman linkman = new Linkman(name);
        PhoneNumber pn = map.get(linkman);
        pn.setRemark(pn.getRemark() + remark);
        }

    public void searchOfSet(String name) throws NoSuchLinkmanException {
        Linkman linkman = new Linkman(name);
        if(!map.containsKey(linkman))
            throw new NoSuchLinkmanException();
    }

    public void delAllInformation(String name) {
        map.remove(new Linkman(name));
    }

    public void delPhoneNum(String name, String phoneNum) throws NoOldPhoneNumException {
        Linkman linkman = new Linkman(name);
        PhoneNumber pn = map.get(linkman);
        List<String> phoneList = pn.getPhoneList();
        for(String string : phoneList) {
            if(string.equals(phoneNum)) {
                phoneList.remove(phoneNum);
                return;
            }
        }
        throw new NoOldPhoneNumException();
    }

    public void delRemark(String name, String remark) throws NoThisRemarkException {
        Linkman linkman = new Linkman(name);
        PhoneNumber pn = map.get(linkman);
        String remarks = pn.getRemark();
        if(remarks.contains(remark)) {
            String[] strs = remarks.split(remark);
            StringBuilder s = new StringBuilder();
            for(String string : strs) {
                s.append(string);
            }
            pn.setRemark(s.toString());
        } else {
            throw new NoThisRemarkException();
        }
    }
}
