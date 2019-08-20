package Poke;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    /*static int POKECARD_NUM;
    {POKECARD_NUM = 52;}*/

    //交换两个下标的扑克牌
    public static void swap(ArrayList<PokeCard> list, int i, int j) {
        PokeCard tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    //想要定义一个随机抽取牌的方法
    /*public static void getPokeCard(ArrayList<PokeCard> list, ArrayList<PokeCard> people) {
        Random r = new Random(1);
        int cardOfA = r.nextInt(POKECARD_NUM);
        people.add(list.get(cardOfA));
        list.remove(cardOfA);
        POKECARD_NUM--;
    }*/

    public static void main(String[] args) {
        //创建一副扑克牌
        ArrayList<PokeCard>  cards = new ArrayList<>(52);
        String[] color = new String[]{"♥", "♦", "♠", "♣"};

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokeCard card = new PokeCard(j, color[i]);
                cards.add(card);
            }
        }

        //打印看扑克牌是否正常创建
        System.out.println("初始化好的扑克牌：");
        System.out.println(cards);
        System.out.println("==========================");
        //洗牌
        //传入固定参数使得生成的牌是不变的，方便下面的测试
        Random r = new Random(1);
        //将牌从最后一张往前遍历
        for (int i = 51; i > 0; i--) {
            //随机生成一张下标在i前面的扑克牌的下标
            int j = r.nextInt(i);
            //交换i 和 j 位置处的扑克牌
            swap(cards, i , j);
        }

        System.out.println("洗牌后的扑克牌：");
        System.out.println(cards);

        System.out.println("================================");

        //有三个人，为每个人发五张牌
        ArrayList<PokeCard> A = new ArrayList<>();
        ArrayList<PokeCard> B = new ArrayList<>();
        ArrayList<PokeCard> C = new ArrayList<>();

        /*//让三个人轮流抽牌，每人抽五张
        int cardNum = 52;
        for (int i = 0; i < 5; i++) {
            getPokeCard(cards, A);
            getPokeCard(cards, B);
            getPokeCard(cards, C);

            //为 A 抽一张牌
            int cardOfA = r.nextInt(cardNum);
            A.add(cards.remove(cardOfA));
            cardNum--;

            //为 B 抽一张牌
            int cardOfB = r.nextInt(cardNum);
            B.add(cards.remove(cardOfB));
            cardNum--;

            //为 C 抽一张牌
            int cardOfC = r.nextInt(cardNum);
            C.add(cards.remove(cardOfC));
            cardNum--;
        }

        System.out.print("A抽的牌为别是：");
        System.out.println(A);
        System.out.print("B抽的牌为别是：");
        System.out.println(B);
        System.out.print("C抽的牌为别是：");
        System.out.println(C);
        System.out.println("================================");*/

        System.out.println("给牌最后的十五张牌是：");
        System.out.println(cards.subList(52 - 15, 52));
        //给 A B C 三个人轮流发牌，每人发五张
        for (int i = 0; i < 15; i++) {
            //从最后一张开始给每个人轮流派牌
            PokeCard card = cards.remove(cards.size() - 1);
            switch(i % 3) {
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }

        System.out.print("给A派的牌为别是：");
        System.out.println(A);
        System.out.print("给B派的牌为别是：");
        System.out.println(B);
        System.out.print("给C派的牌为别是：");
        System.out.println(C);

        PokeCard heartA = new PokeCard(10,"♥");

        //遍历A集合，判断是否包含 heartA
        for(PokeCard card : A) {
            if (card.equals(heartA))
                System.out.println("A得到的牌包含有牌" + heartA.color + heartA.value);
        }

        //使用方法 contains() 判断 A 集合中是否包含元素 heartA
        if(A.contains(heartA)) {
            System.out.println("A得到的牌中包含牌"+ heartA.color + heartA.value);
        } else {
            System.out.println("A得到的牌中不包含牌"+ heartA.color + heartA.value);
        }

        System.out.println("===============");
        //在遍历的同时在删除元素是不合法的，会抛出并行异常
        /*System.out.println(A);
        for(PokeCard card : A) {
            if(card.equals(heartA)) {
                A.remove(heartA);
            }
        }
        System.out.println(A);*/

        System.out.println(A);
        for(int i = 0; i < A.size(); i++) {
            PokeCard o = A.get(i);
            if(o.equals(heartA)) {
                A.remove(heartA);
            }
        }
        System.out.println(A);

        System.out.println("==================");

        //利用迭代器查找删除元素
        System.out.println(A);
        Iterator<PokeCard> it = A.iterator();
        while(it.hasNext()) {
            PokeCard o = it.next();
            if(o.equals(heartA)) {
                //删除当前迭代器指向的对象
                it.remove();
            }
        }
        System.out.println(A);

    }
}
