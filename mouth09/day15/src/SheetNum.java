public class SheetNum {
    public int titleToNumber(String s) {
        int num = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            num += (array[i] - 'A' + 1) * Math.pow(26, array.length - i - 1);
        }
        return num;
    }
}
