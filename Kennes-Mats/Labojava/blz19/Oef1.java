import java.lang.*;

public class Oef1
{
public static void main(String args[])
{

			int tafel=1;
			int getal = 1;
			
			while (tafel<10)
			{
			while (getal<10)
				{
					int resultaat = tafel * getal;
					System.out.println(tafel + " * " + getal + " = " + resultaat);
					getal++;
				}
			getal=1;
			tafel++;
			System.out.println("\n");
			}


}
}