package Maths;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Element {
    int person;
    int money;

    public Element(int person, int money) {
        this.person = person;
        this.money = money;
    }
}

public class GetMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1.split(" ")[0]);
        int m = Integer.parseInt(s1.split(" ")[1]);
        String s2 = sc.nextLine();
        int[] array = new int[n];
        String[] strings = s2.split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(array);
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            Element e = new Element(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
            list.add(e);
        }
        List<Element> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(null);
        }
        int index = 0;
        int sum = 0;
        for (int i : array) {
            for (Element e : list) {
                if (e.person <= i) {
                    Element element = result.get(index);
                    if (!result.contains(e)) {
                        if (element == null) {
                            result.set(index, e);
                        } else {
                            if (e.money > element.money && !result.contains(e)) {
                                result.set(index, e);
                            }
                        }
                    }
                }
            }
            if (result.get(index) != null)
                sum += result.get(index).money;
            index++;
        }
        System.out.println(sum);
    }
}
/*
3 5
2 4 2
1 3
3 5
3 7
5 9
1 10
 */