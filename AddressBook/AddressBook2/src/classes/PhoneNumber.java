package classes;

import java.util.List;

public class PhoneNumber {
    private String remark;
    private List<String> phoneList;

    public PhoneNumber(String remark, List<String> list) {
        this.remark = remark;
        this.phoneList = list;
    }

    public String getRemark() {
        return remark;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
}
