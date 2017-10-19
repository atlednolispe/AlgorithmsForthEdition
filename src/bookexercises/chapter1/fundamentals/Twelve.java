package bookexercises.chapter1.fundamentals;

public class Twelve {
    public static void out() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            //book maybe error - System.out.println(i);
            System.out.println(a[i]);
    }
    public static void main(String[] args) {
        Twelve.out();
    }
}
