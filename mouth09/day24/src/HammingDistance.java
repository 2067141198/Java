public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int[] xBinary = new int[32];
        int i = 0;
        int[] yBinary = new int[32];
        int j = 0;
        while(x > 0) {
            xBinary[i++] = x % 2;
            x /= 2;
        }
        while(y > 0) {
            yBinary[j++] = y % 2;
            y /= 2;
        }
        int count = 0;
        for(int k = 0; k < 32; k++) {
            if(xBinary[k] != yBinary[k]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
