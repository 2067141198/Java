package Maths;

import java.util.Scanner;

/**
 * 题目描述：
 * 北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
 * 公式如下：
 * 实际成绩  绩点
 * 90——100 4.0
 * 85——89  3.7
 * 82——84  3.3
 * 78——81  3.0
 * 75——77  2.7
 * 72——74  2.3
 * 68——71  2.0
 * 64——67  1.5
 * 60——63  1.0
 * 60以下   0
 * 1．一门课程的学分绩点=该课绩点*该课学分
 * 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。
 * <p>
 * 输入描述：第一行 总的课程数n（n<10）；
 * 第二行 相应课程的学分（两个学分间用空格隔开）；
 * 第三行 对应课程的实际得分；
 * 此处输入的所有数字均为整数。
 * <p>
 * 输出描述：输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
 */
public class GetGAP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            //科目学分的数组
            String[] credits = sc.nextLine().split(" ");
            //对应科目的分数
            String[] scores = sc.nextLine().split(" ");

            int creditSum = 0;
            double GAPSum = 0.00;
            for (int i = 0; i < n; i++) {
                int credit = Integer.parseInt(credits[i]);
                int score = Integer.parseInt(scores[i]);
                double GAP;
                if (score <= 100 && score >= 90)
                    GAP = 4.0;
                else if (score <= 89 && score >= 85)
                    GAP = 3.7;
                else if (score <= 84 && score >= 82)
                    GAP = 3.3;
                else if (score <= 81 && score >= 78)
                    GAP = 3.0;
                else if (score <= 77 && score >= 75)
                    GAP = 2.7;
                else if (score <= 75 && score >= 72)
                    GAP = 2.3;
                else if (score <= 71 && score >= 68)
                    GAP = 2.0;
                else if (score <= 67 && score >= 64)
                    GAP = 1.5;
                else if (score <= 63 && score >= 60)
                    GAP = 1.0;
                else
                    GAP = 0;

                GAPSum += GAP * credit;
                creditSum += credit;
            }
            double result = GAPSum / creditSum;
            System.out.printf("%.2f", result);
        }
    }
}
