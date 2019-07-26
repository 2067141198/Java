import java.util.ArrayList;

public class Dome01PrintSumMaxArray {
    public static void main(String[] args) {
        int[] list = {1,-2,3,10,-4,7,2,-5};
        int count = 0;

        ArrayList<Integer> listSum = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            int sum = list[i];
            for (int j = i; j < list.length; j++) {
                if(i == j) {
                    listSum.add(list[i]);
                } else {
                    sum += list[j];
                    listSum.add(sum);
                }
                count++;
            }
        }
        System.out.println(listSum);
        System.out.println(count);

        int sumMax = 0;
        for (int i = 0; i < listSum.size(); i++) {
            if(listSum.get(i) > sumMax)
                sumMax = listSum.get(i);
        }

        for (int i = 0; i < list.length; i++) {
            int sum = list[i];
            for (int j = i; j < list.length; j++) {
                if(i == j) {
                    listSum.add(list[i]);
                } else {
                    sum += list[j];
                    listSum.add(sum);
                }

                if(sum == sumMax) {
                    System.out.println(list[i]);
                    System.out.print("{");
                    for (int k = i; k <= j; k++) {
                        if(k == j) {
                            System.out.print(list[k]);
                        } else {
                            System.out.print(list[k] + ",");
                        }
                    }
                    System.out.println("}");
                }
            }
        }
    }
}
