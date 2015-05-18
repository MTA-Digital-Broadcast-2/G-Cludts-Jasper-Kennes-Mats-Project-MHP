import java.lang.*;

public class Oef2
{
public static void main(String args[])
	{
int getal = 1;
int i=0;
//string maand = "Februari";

String dagen[] = {"Zondag", "Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag"};

while(getal<29)
{

if (i>6)
{
i=0;
}

System.out.println(dagen[i] + " " + getal + " februari");
getal++;
i++;
	}
}
}