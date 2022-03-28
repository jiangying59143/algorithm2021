package class00MyStudy;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class ASCII {

    public static final char generateRandomNumberAndLetter(){
        Random random = new Random();
        int x = random.nextInt(10) + 48;
        int y= random.nextInt(26) + 65;
        int z= random.nextInt(26) + 97;
        int[] arr = new int[]{x, y, z};
        int selection = random.nextInt(3);
        return (char)arr[selection];
    }


    public static void printRange(Predicate<Character> predicate){
        for (int i = 0; i < 255; i++) {
            char x = (char) i;
            if (predicate.test(x)) {
                System.out.print(x);
                System.out.print("(" + i + ")");
                System.out.print(" ");
            }
        }
    }


    public static void main(String[] args) {
        printRange((Character c)-> c>='0' && c<='9');
        System.out.println();
        printRange((Character c)-> c>='A' && c<='Z');
        System.out.println();
        printRange((Character c)-> c>='a' && c<='z');
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(generateRandomNumberAndLetter());
        }
        System.out.println(sb);
    }
}
