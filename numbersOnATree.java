import java.util.*;
import java.lang.Math;

public class numbersOnATree {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        String str = (sc.hasNext()) ? sc.next() : "";

        int current = (int)(Math.pow(2, h + 1) - 1);

        char left = 'L';
        char right = 'R';

        int sub = 0;
        char prev = 'N';

        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);

            if (prev == 'N')
            {
                sub = (c == 'L') ? 1 : 2;
            }
            else
            {
                if (c == prev)
                {
                    sub *= 2;
                }
                else if (prev == 'L' && c == 'R')
                {
                    sub = 2*sub + 1;
                }
                else // if (prev == 'R' && c == 'L)
                {
                    sub = 2*sub - 1;
                }
            }

            current -= sub;
            prev = c;
        }

        System.out.println(current);
    }
}
