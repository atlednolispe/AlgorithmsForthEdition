package bookexercises.chapter1.fundamentals;

/**
 * Explain each outcome
 * a. System.out.println('b');
 * b. System.out.println('b' + 'c');
 * c. System.out.println((char) ('a' + 4));
 */
public class Eight {

    public static void main(String[] args) {
        //print char
        System.out.println('b');

        //char + char = int
        System.out.println('b' + 'c');

        //int cast to char
        System.out.println((char) ('a' + 4));
    }
}
