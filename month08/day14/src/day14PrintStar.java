public class day14PrintStar {
    public static void main(String args[]) {
        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        for (int i = 0; i < h; i++) {
            StringBuffer sb = new StringBuffer();
            for (int i1 = 0; i1 < w; i1++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }
}
