import java.util.ArrayList;

public class Dome02ArrayListEach {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("王一");
        list.add("王二");
        list.add("王三");
        list.add("王四");

        //遍历集合
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
