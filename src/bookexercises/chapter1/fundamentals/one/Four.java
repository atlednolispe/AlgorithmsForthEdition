package bookexercises.chapter1.fundamentals.one;

/**
 * What (if anything) is wrong with each of the following statements?
 * a. if (a > b) then c = 0;
 * b. if a > b { c = 0; }
 * c. if (a > b) c = 0;
 * d. if (a > b) c = 0 else b = 0;
 */
public class Four {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;

        //Error: then
        //if (a > b) then c = 0;

        //Missing ()
        //if a > b { c = 0; }

        //OK
        if (a > b) c = 0;

        //Missing ;
        //if (a > b) c = 0 else b = 0;
    }
}
