package src;

import java.util.List;

public class PhoneNumShelf {

    private String remark;
    private List<String> numList;

    public PhoneNumShelf() {
    }

    public PhoneNumShelf(String remark, List<String> numList) {
        this.remark = remark;
        this.numList = numList;
    }

    public String getRemark() {
        return remark;
    }

    public List<String> getNumList() {
        return numList;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setNumList(List<String> numList) {
        this.numList = numList;
    }
}
