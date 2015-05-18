import java.lang.*;
import java.util.Arrays;

public class Oef7
{
public static void main(String args[])
{
int a[] = {12,34,56,78,123,234,99,88};
        int b[] = new int[8];
        
        int i, j, k, grootste;
        for(k = 0; k < a.length; k++) {
            grootste = 0;
            for(i = 0; i < a.length; i++) {
                if(a[i] > 0 && a[i] > grootste) {
                    grootste = a[i];

                }
            }
            for(j = 0; j < a.length; j++) {
                if(a[j] == grootste) {
                    a[j] = 0;
                }
            }
            b[k] = grootste;
            System.out.println(b[k] + " ");
			// System.out.println(a[k] + " ");
}
}
}